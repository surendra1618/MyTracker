package com.cubic.rest;

import org.springframework.stereotype.Component;

import com.cubic.exception.InvalidInputException;
import com.cubic.vo.RouteVO;

@Component
public class RouteInputValidator {

	public void validate(final RouteVO routeVo) {

		if (routeVo.getStartLocation() == null || routeVo.getEndLocation() == null || routeVo.getStartLocation().equals("")
				|| routeVo.getEndLocation().equals("")) {
			throw new InvalidInputException("Start Location and End Location can not be null or empty");
		}
	}
}
