package com.sam.service.issue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.sam.bean.ProductCategoryBean;
import com.sam.repository.IssueRepository;
import com.sam.util.ResponseBean;
import com.sam.util.SessionFactoryUtil;

@Service
@RequestScope
public class IssueServiceImpl implements IssueService {
	private Session session;

	private final IssueRepository repository;
	private final ResponseBean responseBean;

	public IssueServiceImpl(IssueRepository repository) {
		this.repository = repository;
		this.responseBean = new ResponseBean();
	}

	@Override
	public ResponseBean getAllTopCategories() {
		// TODO Auto-generated method stub
		try {

			session = SessionFactoryUtil.getInstance("issues").openSession();

			List<ProductCategoryBean> resultList = repository.getIssues(session);

			System.err.println(resultList);

			if (resultList == null || resultList.size() == 0) {

				responseBean.setResult(new HashMap<String, Object>());

			} else {

				responseBean.setResult(resultList);

			}

			return responseBean;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (session != null && session.isOpen()) {
					session.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return responseBean;
	}

}
