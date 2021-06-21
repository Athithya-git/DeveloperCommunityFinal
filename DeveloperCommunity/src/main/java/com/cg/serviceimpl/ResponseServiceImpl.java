package com.cg.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Response;
import com.cg.repository.ResponseRepository;
import com.cg.service.ResponseService;

@Service
public class ResponseServiceImpl implements ResponseService {
	@Autowired
	ResponseRepository repo;

	public ResponseRepository getrepo() {
		return repo;
	}

	public void setrepo(ResponseRepository repo) {
		this.repo = repo;
	}

// getting the response data
	@Override
	public List<Response> getAllResponses() {

		return repo.findAll();

	}

//adding and saving the response data
	@Override
	public Response saveResponse(Response response) {
		Response newResponse = repo.save(response);
		return newResponse;
	}

// editing and saving response data
	@Override
	public Response editResponse(Response response) {
		Response newResponse = repo.save(response);
		return newResponse;
	}

// getting the response data by response id
	@Override
	public Response getById(int respId) {
		Response newResponse = repo.getById(respId);
		return newResponse;
	}

//removing the response data
	@Override
	public void removeResponse(int respId) {

		repo.deleteById(respId);

	}

}
