package com.cubic.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
public class VehicleEntity {

	@Id
	@Column(name = "VEHICLE_ID")
	@SequenceGenerator(name = "vehicleSeq", sequenceName = "VEHICLE_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "vehicleSeq")
	private Long vehicleId;

	@Column(name = "VEHICLE_NAME")
	private String vehicleName;

	@Column(name = "VEHICLE_STATUS")
	private String vehicleStatus;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle")
	private List<ScheduleEntity> schedules;

	public List<ScheduleEntity> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<ScheduleEntity> schedules) {
		this.schedules = schedules;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	@Override
	public String toString() {
		return "VehicleEntity [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", vehicleStatus="
				+ vehicleStatus + ", schedules=" + schedules + "]";
	}

}
