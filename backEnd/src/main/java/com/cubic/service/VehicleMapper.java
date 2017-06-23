package com.cubic.service;

import org.springframework.stereotype.Component;

import com.cubic.entity.VehicleEntity;
import com.cubic.vo.VehicleVO;

@Component
public class VehicleMapper {

	public VehicleVO mapToVechicleVO(VehicleEntity vehicleEntity) {
		VehicleVO vehicleVo = new VehicleVO();

		vehicleVo.setVehicleId(vehicleEntity.getVehicleId());
		vehicleVo.setVehicleName(vehicleEntity.getVehicleName());
		vehicleVo.setVehicleStatus(vehicleEntity.getVehicleStatus());

		return vehicleVo;
	}

	public VehicleEntity mapToVehicleEntity(VehicleVO vehicleVo, VehicleEntity vehicleEntity) {
		vehicleEntity.setVehicleId(vehicleVo.getVehicleId());
		vehicleEntity.setVehicleName(vehicleVo.getVehicleName());
		vehicleEntity.setVehicleStatus(vehicleVo.getVehicleStatus());

		return vehicleEntity;
	}

	public VehicleEntity mapToVehicleEntity(VehicleVO vehicleVo) {
		VehicleEntity vehicleEntity = new VehicleEntity();

		return mapToVehicleEntity(vehicleVo, vehicleEntity);
	}

}
