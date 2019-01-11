package com.hqyj.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hqyj.pojo.ExamQuestion;

public interface ExamService {

	public void createSingleQuestion(HttpServletRequest request);

	public List<ExamQuestion> queryAllQuestion(int currentpage, int pagesize);
}
