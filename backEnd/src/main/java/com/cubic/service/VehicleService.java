package com.cubic.service;

import com.cubic.vo.VehicleVO;

public interface VehicleService {

	VehicleVO findVehicle(final Long vehicleId);

	VehicleVO createVehicle(final VehicleVO vehicleVo);
	
	VehicleVO updateVehicle(final VehicleVO vechileVo);

	void removeVehicle(final Long vehicleId);

}
