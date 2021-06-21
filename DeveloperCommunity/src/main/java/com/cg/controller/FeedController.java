package com.cg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Developer;
import com.cg.entity.Feed;
import com.cg.service.DeveloperService;
import com.cg.service.FeedService;
import com.cg.service.ResponseService;

@RestController
@RequestMapping("/api/v1")
public class FeedController {

	@Autowired
	FeedService feedService;

	@Autowired
	DeveloperService developerService;
	@Autowired
	ResponseService responseService;
	List<Feed> feeds = new ArrayList<Feed>();

	public List<Feed> getAllFeeds() {
		return feeds;
	}

// adding and saving the feed data in the database
	@PostMapping(path = "/feeds", consumes = { "application/json" })
	public ResponseEntity<List<Feed>> saveFeed(@RequestBody Feed feed) {

		Feed newFeed = feedService.saveFeed(feed);

		return new ResponseEntity<List<Feed>>(feeds, HttpStatus.OK);
	}

	// adding and saving the feed data in the database with developer id
	@PostMapping(path = "/feeds/devId/{devId}", consumes = { "application/json" })
	public ResponseEntity<Feed> getDeveloperId(@RequestBody Feed feed, @PathVariable("devId") int devId) {

		Developer developer = developerService.getById(devId);

		feed.setDeveloper(developer);
		Feed newFeed = feedService.saveFeed(feed);

		return new ResponseEntity<Feed>(newFeed, HttpStatus.OK);

	}

//getting the feed data in the database
	@GetMapping(path = "/feeds", produces = { "application/json" })
	public ResponseEntity<List<Feed>> getFeeds() {
		List<Feed> feedsList = feedService.getAllFeeds();

		return new ResponseEntity<List<Feed>>(feedsList, HttpStatus.OK);
	}

	// update the feeds by by feedId in the database
	@PutMapping("/feeds/feedId/{feedId}")
	public ResponseEntity<Feed> updateFeed(@PathVariable(value = "feedId") int feedId, @RequestBody Feed newFeed) {

		Feed feed = feedService.getById(feedId);

		feed.setFeedDate(newFeed.getFeedDate());
		feed.setFeedTime(newFeed.getFeedTime());
		feed.setQuery(newFeed.getQuery());
		feed.setRelevance(newFeed.getRelevance());
		feed.setResponses(newFeed.getResponses());
		feed.setTopic(newFeed.getTopic());
		feed.setTotalComments(newFeed.getTotalComments());
		feed.setLikes(newFeed.getLikes());
		final Feed updatedFeed = feedService.editFeed(feed);
		return ResponseEntity.ok(updatedFeed);

	}

// liking the feed using feedId
	@PutMapping("/feeds/feedId/likes/{feedId}")
	public ResponseEntity<Feed> updateFeed1(@PathVariable(value = "feedId") int feedId,
			@Validated @RequestBody Feed newFeed) {

		Feed feed = feedService.getById(feedId);

		feed.setLikes(newFeed.getLikes());
		final Feed updatedFeed1 = feedService.editFeed(feed);
		return ResponseEntity.ok(updatedFeed1);

	}

	// Delete feeds by feedId
	@DeleteMapping("/feeds/feedId/{feedId}")
	public ResponseEntity<Feed> removeFeed(@PathVariable(value = "feedId") int feedId) {
		feedService.removeFeed(feedId);
		return new ResponseEntity<Feed>(HttpStatus.NO_CONTENT);
	}

//Get feeds by topic		
	@GetMapping("/feeds/topic/{topic}")
	public List<Feed> findFeedByTopic(@PathVariable("topic") String topic) {
		List<Feed> feeds = feedService.findFeedByTopic(topic);
		return feeds;
	}

//Get feeds by Keyword		
	@GetMapping("/feeds/topic/keyword/{keyword}")
	public List<Feed> findFeedByKeyword(@PathVariable("keyword") String keyword) {
		List<Feed> feeds = feedService.findFeedByKeyword(keyword);
		return feeds;
	}
}
