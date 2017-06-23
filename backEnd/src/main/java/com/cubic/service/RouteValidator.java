package com.cubic.service;

import org.springframework.stereotype.Component;

import com.cubic.entity.RouteEntity;
import com.cubic.exception.DataNotFoundException;
import com.cubic.exception.DeletionNotAllowedException;

@Component
public class RouteValidator {

	public void validate(final RouteEntity routeEntity) {
		if (routeEntity == null) {
			throw new DataNotFoundException("The Route does not exist in the system.");
		}
	}

	public void checkRouteSchedule(final RouteEntity routeEntity) {
		if (routeEntity.getSchedules().size() > 0) {
			throw new DeletionNotAllowedException(
					"This route is currently scheduled. Please unschedule the route before deleting.");
		}
	}

}
