package com.sam.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam.bean.LanguageBean;
import com.sam.bean.ProductCategoryBean;

@Repository
@RequestScope
public class IssueRepository {

	private final ObjectMapper objectMapper;

	public IssueRepository() {
		this.objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	}

	public HashMap<String, Object> getIssues(Session session) throws JsonProcessingException {

		HashMap<String, Object> resultMap = new HashMap<>();

		String sql = "SELECT "
				+ "tc.oid AS tc_oid, tc.catCode AS tc_code, tc.catName AS tc_name, tc.activeStatus AS tc_status, tc.createDate AS tc_createDate, tc.modifiedBy AS tc_createdBy, "
				+ "pc.oid AS pc_oid, pc.catCode AS pc_code, pc.catName AS pc_name, pc.activeStatus AS pc_status, pc.createDate AS pc_createDate, pc.modifiedBy AS pc_createdBy, "
				+ "bc.oid AS bc_oid, bc.catCode AS bc_code, bc.catName AS bc_name, bc.activeStatus AS bc_status, bc.createDate AS bc_createDate, bc.modifiedBy AS bc_createdBy, "
				+ "prod.oid AS prod_oid, prod.catCode AS prod_code, prod.catName AS prod_name, prod.activeStatus AS prod_status, prod.createDate AS prod_createDate, prod.modifiedBy AS prod_createdBy, prod.price, IFNULL(prod.isEditableByMember, '0') isEditableByMember "
				+ "FROM ProductCategory tc "
				+ "INNER JOIN ProductCategory pc ON pc.parentOid = tc.oid AND pc.layerOid = 2 "
				+ "INNER JOIN ProductCategory bc ON bc.parentOid = pc.oid AND bc.layerOid = 3 "
				+ "INNER JOIN ProductCategory prod ON prod.parentOid = bc.oid AND prod.layerOid = 0 "
				+ "WHERE tc.layerOid = 1 " + "ORDER BY tc.oid, pc.oid, bc.oid, prod.oid;";

		NativeQuery<Object[]> query = session.createNativeQuery(sql);
		List<Object[]> results = query.list();

		Map<Integer, ProductCategoryBean> categoryMap = new HashMap<>();
		Map<Integer, ProductCategoryBean> productCategoryMap = new HashMap<>();
		Map<Integer, ProductCategoryBean> brandMap = new HashMap<>();

		for (Object[] row : results) {
			Integer tcOid = (Integer) row[0];
			if (!categoryMap.containsKey(tcOid)) {
				ProductCategoryBean topCategory = new ProductCategoryBean();
				topCategory.setOid(tcOid);
				topCategory.setCode((String) row[1]);
				topCategory.setName(objectMapper.readValue((String) row[2], LanguageBean.class));
				topCategory.setStatus((Integer) row[3]);
				topCategory.setCreateDate((Date) row[4]);
				topCategory.setCreatedBy((Integer) row[5]);
				topCategory.setProductCategories(new ArrayList<>());
				categoryMap.put(tcOid, topCategory);
			}

			Integer pcOid = (Integer) row[6];
			if (pcOid != null && !productCategoryMap.containsKey(pcOid)) {
				ProductCategoryBean productCategory = new ProductCategoryBean();
				productCategory.setOid(pcOid);
				productCategory.setCode((String) row[7]);
				productCategory.setName(objectMapper.readValue((String) row[8], LanguageBean.class));
				productCategory.setStatus((Integer) row[9]);
				productCategory.setCreateDate((Date) row[10]);
				productCategory.setCreatedBy((Integer) row[11]);
				productCategory.setBrands(new ArrayList<>());
				productCategoryMap.put(pcOid, productCategory);
				categoryMap.get(tcOid).getProductCategories().add(productCategory);
			}

			Integer bcOid = (Integer) row[12];
			if (bcOid != null && !brandMap.containsKey(bcOid)) {
				ProductCategoryBean brand = new ProductCategoryBean();
				brand.setOid(bcOid);
				brand.setCode((String) row[13]);
				brand.setName(objectMapper.readValue((String) row[14], LanguageBean.class));
				brand.setStatus((Integer) row[15]);
				brand.setCreateDate((Date) row[16]);
				brand.setCreatedBy((Integer) row[17]);
				brand.setProducts(new ArrayList<>());
				brandMap.put(bcOid, brand);
				productCategoryMap.get(pcOid).getBrands().add(brand);
			}

			Integer prodOid = (Integer) row[18];
			if (prodOid != null) {
				ProductCategoryBean product = new ProductCategoryBean();
				product.setOid(prodOid);
				product.setCode((String) row[19]);
				product.setName(objectMapper.readValue((String) row[20], LanguageBean.class));
				product.setStatus((Integer) row[21]);
				product.setCreateDate((Date) row[22]);
				product.setCreatedBy((Integer) row[23]);
				product.setPrice((Integer) row[24]);
				product.setIsEditableByMember((Integer) Integer.parseInt(row[25].toString()));
				brandMap.get(bcOid).getProducts().add(product);
			}
		}

		List<ProductCategoryBean> topCategoriesList = new ArrayList<ProductCategoryBean>(categoryMap.values());

		if (topCategoriesList == null || topCategoriesList.size() == 0) {
			resultMap.put("topCategories", null);
		}

		resultMap.put("topCategories", topCategoriesList);

		return resultMap;
	}

}
