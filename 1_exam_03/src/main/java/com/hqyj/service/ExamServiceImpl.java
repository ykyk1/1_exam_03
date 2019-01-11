package com.hqyj.service;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.hqyj.dao.ExamAnswerDao;
import com.hqyj.dao.ExamOptionDao;
import com.hqyj.dao.ExamQuestionDao;
import com.hqyj.pojo.ExamAnswer;
import com.hqyj.pojo.ExamOption;
import com.hqyj.pojo.ExamQuestion;

@Service
public class ExamServiceImpl implements ExamService {

	@Resource
	private ExamQuestionDao questiondao;

	@Resource
	private ExamOptionDao optiondao;

	@Resource
	private ExamAnswerDao answerdao;

	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void createSingleQuestion(HttpServletRequest request) {

		ExamQuestion eq = new ExamQuestion();

		eq.setScore(Integer.parseInt(request.getParameter("score")));
		eq.setTitle(request.getParameter("title"));
		eq.setType(Integer.parseInt(request.getParameter("type")));

		questiondao.insert(eq);
		int id = eq.getQuestionId();

		String[] options = request.getParameterValues("options");
		for (int i = 0; i < options.length; i++) {
			
//			if(i==1) {
//				throw new RuntimeException();
//			}
			ExamOption eo = new ExamOption();
			eo.setQuestionId(id);
			eo.setFlag(String.valueOf((char) (65 + i)));
			eo.setContent(options[i]);
			optiondao.insert(eo);
		}
		

		String[] answerIndexs = request.getParameterValues(("answerIndexs"));
		for (String answerIndex : answerIndexs) {
			ExamAnswer ea = new ExamAnswer();
			ea.setQuestionId(id);
			ea.setFlag(String.valueOf((char) (65 + Integer.parseInt(answerIndex))));
			answerdao.insert(ea);
		}
		
		
	}


	@Override
	public List<ExamQuestion> queryAllQuestion(int currentpage, int pagesize) {
		PageHelper.startPage(currentpage, pagesize);
		return questiondao.queryAllQuestion();
		
	}

}
