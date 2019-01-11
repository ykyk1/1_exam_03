package com.hqyj.pojo;

public class ExamAnswer {

	private int answerId;
	private String flag;
	private int questionId;
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	@Override
	public String toString() {
		return "ExamAnswer [answerId=" + answerId + ", flag=" + flag + ", questionId=" + questionId + "]";
	}
	public ExamAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + answerId;
		result = prime * result + ((flag == null) ? 0 : flag.hashCode());
		result = prime * result + questionId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExamAnswer other = (ExamAnswer) obj;
		if (answerId != other.answerId)
			return false;
		if (flag == null) {
			if (other.flag != null)
				return false;
		} else if (!flag.equals(other.flag))
			return false;
		if (questionId != other.questionId)
			return false;
		return true;
	}
	
}
