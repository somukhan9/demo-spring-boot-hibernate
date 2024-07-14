package com.sam.bean;

import java.util.Date;
import java.util.List;

public class ProductCategoryBean {

	private Integer oid;
	private String code;
	private String nameString;
	private LanguageBean name;
	private Integer status;
	private Date createDate;
	private Integer createdBy;
	private Integer isEditableByMember;
	private Integer price;

	private Integer layerOid;
	private Integer parentOid;

	private List<ProductCategoryBean> topCategories;
	private List<ProductCategoryBean> productCategories;
	private List<ProductCategoryBean> brands;
	private List<ProductCategoryBean> products;

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public LanguageBean getName() {
		return name;
	}

	public void setName(LanguageBean name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getIsEditableByMember() {
		return isEditableByMember;
	}

	public void setIsEditableByMember(Integer isEditableByMember) {
		this.isEditableByMember = isEditableByMember;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getLayerOid() {
		return layerOid;
	}

	public void setLayerOid(Integer layerOid) {
		this.layerOid = layerOid;
	}

	public Integer getParentOid() {
		return parentOid;
	}

	public void setParentOid(Integer parentOid) {
		this.parentOid = parentOid;
	}

	public List<ProductCategoryBean> getTopCategories() {
		return topCategories;
	}

	public void setTopCategories(List<ProductCategoryBean> topCategories) {
		this.topCategories = topCategories;
	}

	public List<ProductCategoryBean> getProductCategories() {
		return productCategories;
	}

	public void setProductCategories(List<ProductCategoryBean> productCategories) {
		this.productCategories = productCategories;
	}

	public List<ProductCategoryBean> getBrands() {
		return brands;
	}

	public void setBrands(List<ProductCategoryBean> brands) {
		this.brands = brands;
	}

	public List<ProductCategoryBean> getProducts() {
		return products;
	}

	public void setProducts(List<ProductCategoryBean> products) {
		this.products = products;
	}

}
