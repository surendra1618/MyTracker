package com.cubic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.dao.VehicleDao;
import com.cubic.entity.VehicleEntity;
import com.cubic.vo.VehicleVO;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDao vehicleDao;

	@Autowired
	private VehicleMapper vehicleMapper;

	@Autowired
	private VehicleValidator vehicleValidator;

	public VehicleVO findVehicle(final Long vehicleId) {
		VehicleEntity vehicleEntity = vehicleDao.findVehicle(vehicleId);
		vehicleValidator.validate(vehicleEntity);

		return vehicleMapper.mapToVechicleVO(vehicleEntity);
	}

	public VehicleVO createVehicle(final VehicleVO vehicleVo) {
		VehicleEntity vehicleEntity = null;
		vehicleEntity = vehicleMapper.mapToVehicleEntity(vehicleVo);

		vehicleDao.saveVehicle(vehicleEntity);
		vehicleVo.setVehicleId(vehicleEntity.getVehicleId());

		return vehicleVo;
	}

	public VehicleVO updateVehicle(final VehicleVO vehicleVo) {
		VehicleEntity vehicleEntity = null;
		
		vehicleEntity = vehicleDao.findVehicle(vehicleVo.getVehicleId());
		vehicleValidator.validate(vehicleEntity);

		vehicleEntity = vehicleMapper.mapToVehicleEntity(vehicleVo, vehicleEntity);

		vehicleDao.saveVehicle(vehicleEntity);
		vehicleVo.setVehicleId(vehicleEntity.getVehicleId());

		return vehicleVo;
	}

	public void removeVehicle(final Long vehicleId) {
		VehicleEntity vehicleEntity = vehicleDao.findVehicle(vehicleId);
		vehicleValidator.validate(vehicleEntity);
		vehicleValidator.checkVehicleSchedule(vehicleEntity);

		vehicleDao.removeVehicle(vehicleEntity);
	}

}
