package com.sam.service.issue;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam.bean.IssueBean;
import com.sam.util.RequestBean;
import com.sam.util.ResponseBean;

import jakarta.servlet.http.HttpServletResponse;

@Service
@RequestScope
public class IssueConfigService {

	private RequestBean requestBean;
	private IssueBean bean;

	private final IssueService service;
	private final ResponseBean responseBean;
	private final ObjectMapper objectMapper;

	public IssueConfigService(IssueService service) {
		this.service = service;
		this.responseBean = new ResponseBean();
		this.objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	}

	public Object execute(String json, HttpServletResponse response) throws IOException {
		try {

			requestBean = objectMapper.readValue(json, RequestBean.class);
			bean = objectMapper.treeToValue(requestBean.getData(), IssueBean.class);

			return objectMapper.writeValueAsString(service.getAllTopCategories());

		} catch (Exception e) {
			e.printStackTrace();

			responseBean.setSuccess(2);
			responseBean.setError(e.getMessage());

		}

		return responseBean;

	}
}
