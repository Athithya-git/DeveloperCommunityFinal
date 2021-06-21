package com.cg.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Feed;
import com.cg.exception.FeedIdNotFoundException;
import com.cg.exception.FeedKeywordNotFoundException;
import com.cg.exception.FeedTopicNotFoundException;
import com.cg.repository.FeedRepository;
import com.cg.service.FeedService;

@Service
public class FeedServiceImpl implements FeedService {
	@Autowired
	FeedRepository feedRepository;

	public FeedRepository getFeedRepository() {
		return feedRepository;
	}

	public void setFeedRepository(FeedRepository feedRepository) {
		this.feedRepository = feedRepository;
	}

// getting the feed data
	@Override
	public List<Feed> getAllFeeds() {
		// TODO Auto-generated method stub
		return feedRepository.findAll();
	}

//adding and saving the feed data
	@Override
	public Feed saveFeed(Feed feed) {

		Feed newFeed = feedRepository.save(feed);
		return newFeed;
	}

	// getting feed data by feed id
	@Override
	public Feed getById(int feedId) {
		Optional<Feed> feed = feedRepository.findById(feedId);
		if (feed.isEmpty() || feed == null || feed != feed) {
			throw new FeedIdNotFoundException();
		}
		return feed.get();
	}

	// editing and updating the feed
	@Override
	public Feed editFeed(Feed feed) {

		Feed newFeed = feedRepository.save(feed);

		return newFeed;
	}

	// remove the feed data by feed id
	@Override
	public void removeFeed(int feedId) {

		feedRepository.deleteById(feedId);
	}
	// find feed data by topic

	@Override
	public List<Feed> findFeedByTopic(String topic) {
		List<Feed> feeds = feedRepository.findFeedByTopic(topic);
		if (feeds.isEmpty() || feeds == null || feeds != feeds) {
			throw new FeedTopicNotFoundException();
		}
		return feeds;
	}

// find feed data by keyword
	@Override
	public List<Feed> findFeedByKeyword(String keyword) {
		List<Feed> feeds = feedRepository.findFeedByKeyword(keyword);
		if (feeds.isEmpty() || feeds == null || feeds != feeds) {
			throw new FeedKeywordNotFoundException();
		}
		return feeds;
	}

}
