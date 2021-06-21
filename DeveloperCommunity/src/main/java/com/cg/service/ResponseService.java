package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Response;

@Service
public interface ResponseService {

	public List<Response> getAllResponses();

	public Response saveResponse(Response response);

	public Response editResponse(Response response);

	public Response getById(int respId);

	public void removeResponse(int respId);
}
