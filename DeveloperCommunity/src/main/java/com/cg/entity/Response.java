package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Response {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int respId;
	String answer;
	String respDate;

	String respTime;
	int accuracy;
	String likes;

	@ManyToOne(fetch = FetchType.EAGER)
	private Feed feed;

	public Response(int respId, String answer, String respDate, String respTime, int accuracy, String likes,
			Feed feed) {
		super();
		this.respId = respId;
		this.answer = answer;
		this.respDate = respDate;
		this.respTime = respTime;
		this.accuracy = accuracy;
		this.likes = likes;
		this.feed = feed;
	}

	public Response() {
	}

	public int getRespId() {
		return respId;
	}

	public void setRespId(int respId) {
		this.respId = respId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getRespDate() {
		return respDate;
	}

	public void setRespDate(String respDate) {
		this.respDate = respDate;
	}

	public String getRespTime() {
		return respTime;
	}

	public void setRespTime(String respTime) {
		this.respTime = respTime;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public Feed getFeed() {
		return feed;
	}

	public void setFeed(Feed feed) {
		this.feed = feed;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public String getLikes() {
		return likes;
	}

	@Override
	public String toString() {
		return "Response [respId=" + respId + ", answer=" + answer + ", respDate=" + respDate + ", respTime=" + respTime
				+ ", accuracy=" + accuracy + ", likes=" + likes + ", feed=" + feed + "]";
	}

}
