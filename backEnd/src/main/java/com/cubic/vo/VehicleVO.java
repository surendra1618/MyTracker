package com.cubic.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VehicleVO {

	private Long vehicleId;

	private String vehicleName;

	private String vehicleStatus;

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
		return "VehicleVO [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", vehicleStatus=" + vehicleStatus
				+ "]";
	}

}
