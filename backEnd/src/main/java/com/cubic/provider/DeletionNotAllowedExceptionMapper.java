package com.cubic.provider;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.cubic.exception.DeletionNotAllowedException;
import com.cubic.vo.ErrorResponse;

@Component
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class DeletionNotAllowedExceptionMapper implements ExceptionMapper<DeletionNotAllowedException> {

	public Response toResponse(DeletionNotAllowedException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode("err-val-409: Conflict");
		errorResponse.setErrorDesc(exception.getMessage());
		return Response.serverError().entity(errorResponse).build();
	}

}
