package com.cubic.dao;

import com.cubic.entity.VehicleEntity;

public interface VehicleDao {
	
	VehicleEntity findVehicle(final Long vehicleId);

	void saveVehicle(final VehicleEntity vehicleEntity);

	void removeVehicle(final VehicleEntity vehicleEntity);

}
