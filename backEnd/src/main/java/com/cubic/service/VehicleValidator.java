package com.cubic.service;

import org.springframework.stereotype.Component;

import com.cubic.entity.VehicleEntity;
import com.cubic.exception.DataNotFoundException;
import com.cubic.exception.DeletionNotAllowedException;
import com.cubic.vo.VehicleVO;

@Component
public class VehicleValidator {

	public void validate(final VehicleEntity vehicleEntity) {
		if (vehicleEntity == null) {
			throw new DataNotFoundException("The Vehicle does not exist in the system.");
		}
	}

	public void validate(final VehicleVO vehicleVo) {

	}

	public void checkVehicleSchedule(final VehicleEntity vehicleEntity) {
		if (vehicleEntity.getSchedules().size() > 0) {
			throw new DeletionNotAllowedException(
					"This Vehicle is currently scheduled. Please unschedule the vehicle before deleting.");
		}
	}
}
