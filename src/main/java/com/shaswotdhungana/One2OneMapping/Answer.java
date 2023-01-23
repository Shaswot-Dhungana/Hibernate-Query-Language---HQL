package com.shaswotdhungana.One2OneMapping;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;




@Entity(name="Answers")
public class Answer {
	
	@Id
	@Column(name="answer_id")
	private int answerId;
	
	private String answer;
	
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}
	
	
	
}
