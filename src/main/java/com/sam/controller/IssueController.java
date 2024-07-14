package com.sam.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sam.service.issue.IssueConfigService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class IssueController {

	private final IssueConfigService issueConfigService;

	public IssueController(IssueConfigService issueConfigService) {
		this.issueConfigService = issueConfigService;
	}

	@PostMapping(value = "/issue", produces = "application/json")
	public Object issueEndPoint(@RequestParam("json") String json, HttpServletResponse response) throws IOException {

		return issueConfigService.execute(json, response);
	}

}
