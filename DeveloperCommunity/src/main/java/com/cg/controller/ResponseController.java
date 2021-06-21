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

import com.cg.entity.Feed;
import com.cg.entity.Response;
import com.cg.exception.ResourceNotFoundException;
import com.cg.service.DeveloperService;
import com.cg.service.FeedService;
import com.cg.service.ResponseService;

@RestController
@RequestMapping("/api/v1")
public class ResponseController {

	@Autowired
	DeveloperService developerService;

	@Autowired
	ResponseService responseService;
	@Autowired
	FeedService feedService;
	List<Response> responses = new ArrayList<Response>();

	public List<Response> getAllResponses() {
		return responses;
	}

//add response data in the database
	@PostMapping(path = "/responses", consumes = { "application/json" })
	public ResponseEntity<List<Response>> saveResponse(@RequestBody Response response) {
		Response newResponse;
		try {
			newResponse = responseService.saveResponse(response);
			if (newResponse == null) {
				throw new ResourceNotFoundException("Response Not found..");
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("Invalid Response");
		}

		return new ResponseEntity<List<Response>>(responses, HttpStatus.OK);
	}

//adding the response data with feed id in the database
	@PostMapping(path = "/responses/feedId/{feedId}", consumes = { "application/json" })
	public ResponseEntity<Response> getResponseId(@RequestBody Response response, @PathVariable("feedId") int feedId) {

		Feed feed = feedService.getById(feedId);

		response.setFeed(feed);
		Response newResponse = responseService.saveResponse(response);

		return new ResponseEntity<Response>(newResponse, HttpStatus.OK);

	}

	// editing and updating the response data in the database
	@PutMapping("/responses/{respId}")
	public ResponseEntity<Response> updateResponse(@PathVariable(value = "respId") int respId,
			@RequestBody Response responseDetails)

	{
		Response response;
		try {
			response = responseService.getById(respId);
			if (response == null) {
				throw new ResourceNotFoundException("Response Id Not found..");
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("Invalid Response Id");
		}
		response.setAnswer(responseDetails.getAnswer());
		response.setAccuracy(responseDetails.getAccuracy());
		// response.setFeed(responseDetails.getFeed());
		response.setRespDate(responseDetails.getRespDate());
		response.setRespTime(responseDetails.getRespTime());
		response.setRespId(responseDetails.getRespId());

		final Response updatedResponse = responseService.editResponse(response);

		return ResponseEntity.ok(updatedResponse);
	}

	// liking the response using response id
	@PutMapping("/response/respId/likes/{respId}")
	public ResponseEntity<Response> updateResponse1(@PathVariable(value = "respId") int respId,
			@Validated @RequestBody Response newResponse) {
		Response response;
		try {

			response = responseService.getById(respId);
			if (response == null) {
				throw new ResourceNotFoundException("Response Id Not found..");
			}
		}

		catch (Exception e) {
			throw new ResourceNotFoundException("Invalid Response Details");
		}
		response.setLikes(newResponse.getLikes());
		final Response updatedResponse1 = responseService.editResponse(response);
		return ResponseEntity.ok(updatedResponse1);

	}

//	Get Response by respId
	@GetMapping(path = "/responses/{respId}", produces = { "application/json" })
	public ResponseEntity<Response> getResponseByrespId(@PathVariable("respId") int respId) {
		Response response;
		try {

			response = responseService.getById(respId);
			if (response == null) {
				throw new ResourceNotFoundException("Response Id Not found..");
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("Invalid Response");
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

//get response data in the database
	@GetMapping(path = "/responses")
	public ResponseEntity<List<Response>> getResponses1() {
		List<Response> responsesList;
		try {

			responsesList = responseService.getAllResponses();
			if (responsesList == null) {
				throw new ResourceNotFoundException("Response Id Not found..");
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("Invalid Response");
		}
		return new ResponseEntity<List<Response>>(responsesList, HttpStatus.OK);
	}

//	Get response DevId
	@GetMapping(path = "/responses/{devId}", produces = { "application/json" })
	public ResponseEntity<Response> getResponseById(@PathVariable("devId") int devId) {
		Response response;
		try {
			response = responseService.getById(devId);
			if (response == null) {
				throw new ResourceNotFoundException("Response Id Not found..");
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("Invalid Response");
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

//  remove reponse by respId	
	@DeleteMapping("/responses/respId/{respId}")
	public ResponseEntity<Response> removeResponse(@PathVariable(value = "respId") int respId) {
		try {
			responseService.removeResponse(respId);

		} catch (Exception e) {
			throw new ResourceNotFoundException("Invalid Response");
		}

		return new ResponseEntity<Response>(HttpStatus.NO_CONTENT);
	}
}
