package com.hqyj.action;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.hqyj.pojo.ExamQuestion;
import com.hqyj.service.ExamService;

@Controller
@RequestMapping("SysQuesAction")
public class SysQuesAction {

	@Resource
	ExamService examService;

	@RequestMapping("/addQuestion")
	public String addQuestion() {
		return "sys/question/add";
	}

	@RequestMapping("/addQuestionSuccess")
	public String addQuestionSuccess(HttpServletRequest request) {

		examService.createSingleQuestion(request);
		return "sys/question/tip";
	}

	@RequestMapping("/listQuestion")
	public String listQuestion(Map map) {

		int currentpage = 1;
		int pagesize = 2;
		List<ExamQuestion> exams = examService.queryAllQuestion(currentpage ,pagesize);
		PageInfo pages = new PageInfo(exams);
		map.put("pages", pages);
		return "sys/question/list";
	}
}
