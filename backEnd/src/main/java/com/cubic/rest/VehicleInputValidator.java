package com.cubic.rest;

import org.springframework.stereotype.Component;

import com.cubic.exception.InvalidInputException;
import com.cubic.vo.VehicleVO;

@Component
public class VehicleInputValidator {

	public void validate(final VehicleVO vehicleVo) {
		if (vehicleVo.getVehicleName() == null || vehicleVo.getVehicleStatus() == null
				|| vehicleVo.getVehicleName().equals("") || vehicleVo.getVehicleStatus().equals("")) {
			throw new InvalidInputException("Vehicle Name or Status can not be null or empty.");
		}

		if (!vehicleVo.getVehicleStatus().equalsIgnoreCase("Active")
				&& !vehicleVo.getVehicleStatus().equalsIgnoreCase("Inactive")) {
			throw new InvalidInputException("Vehicle Status must either be active or inactive");
		}
	}

}
