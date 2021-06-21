package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Feed;

@Service
public interface FeedService {

	List<Feed> getAllFeeds();

	Feed saveFeed(Feed feed);

	public Feed getById(int feedId);

	public Feed editFeed(Feed feed);

	public void removeFeed(int feedId);

	public List<Feed> findFeedByTopic(String topic);

	public List<Feed> findFeedByKeyword(String keyword);

}
