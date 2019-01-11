package com.hqyj.dao;


import java.util.List;

import com.hqyj.pojo.ExamQuestion;

public interface ExamQuestionDao {

	int insert(ExamQuestion eq);

	List<ExamQuestion> queryAllQuestion();
}
