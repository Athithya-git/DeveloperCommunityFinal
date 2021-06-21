package com.cg.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Feed {

	@Id
	private int feedId;
	private String query;
	private String topic;
	private int relevance;
	private int totalComments;
	String feedDate;

	private String feedTime;
	private String likes;

	@ManyToOne
	private Developer developer;
	@OneToMany(targetEntity = Response.class, mappedBy = "feed", fetch = FetchType.EAGER)
	private Set<Response> responses = new HashSet<Response>();

	public Feed(int feedId, String query, String topic, int relevance, int totalComments, String feedDate,
			String feedTime, String likes, Developer developer, Set<Response> responses) {
		super();
		this.feedId = feedId;
		this.query = query;
		this.topic = topic;
		this.relevance = relevance;
		this.totalComments = totalComments;
		this.feedDate = feedDate;
		this.feedTime = feedTime;
		this.likes = likes;
		this.developer = developer;
		this.responses = responses;
	}

	public Feed() {
		super();
	}

	public String getFeedDate() {
		return feedDate;
	}

	public void setFeedDate(String feedDate) {
		this.feedDate = feedDate;
	}

	public String getFeedTime() {
		return feedTime;
	}

	public void setFeedTime(String feedTime) {
		this.feedTime = feedTime;
	}

	public int getFeedId() {
		return feedId;
	}

	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getRelevance() {
		return relevance;
	}

	public void setRelevance(int relevance) {
		this.relevance = relevance;
	}

	public int getTotalComments() {
		return totalComments;
	}

	public void setTotalComments(int totalComments) {
		this.totalComments = totalComments;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public Set<Response> getResponses() {
		return responses;
	}

	public void setResponses(Set<Response> responses) {
		this.responses = responses;
	}

	@Override
	public String toString() {
		return "Feed [feedId=" + feedId + ", query=" + query + ", topic=" + topic + ", relevance=" + relevance
				+ ", totalComments=" + totalComments + ", feedDate=" + feedDate + ", feedTime=" + feedTime + ", likes="
				+ likes + ", developer=" + developer + ", responses=" + responses + "]";
	}

}