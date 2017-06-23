package com.cubic.provider;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.cubic.exception.DataNotFoundException;
import com.cubic.vo.ErrorResponse;

@Component
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	public Response toResponse(DataNotFoundException exception) {
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setErrorCode("Err-Val-404: Data Not Found");
		errorResponse.setErrorDesc(exception.getMessage());
		return Response.serverError().entity(errorResponse).build();
	}

}
