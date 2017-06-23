package com.cubic.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.cubic.entity.VehicleEntity;

@Component
public class VehicleDaoImpl implements VehicleDao {

	@PersistenceContext
	private EntityManager em;

	public VehicleEntity findVehicle(Long vehicleId) {
		return em.find(VehicleEntity.class, vehicleId);
	}

	public void saveVehicle(VehicleEntity vehicleEntity) {
		em.persist(vehicleEntity);
	}

	public void removeVehicle(VehicleEntity vehicleEntity) {
		em.remove(vehicleEntity);
	}

}
