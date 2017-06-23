package com.cubic.provider;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.cubic.exception.InvalidInputException;
import com.cubic.vo.ErrorResponse;

@Component
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class InvalidInputExceptionMapper implements ExceptionMapper<InvalidInputException> {

	public Response toResponse(InvalidInputException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode("err-val-406: Invalid Input");
		errorResponse.setErrorDesc(exception.getMessage());
		return Response.serverError().entity(errorResponse).build();
	}
}
