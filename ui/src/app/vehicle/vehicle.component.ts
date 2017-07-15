import {Component, OnInit} from '@angular/core';

import {VehicleService} from './vehicle.service';
import {IVehicle} from './vehicle';

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css']
})
export class VehicleComponent implements OnInit {
  title: string;
  vehicleParam: any;

  newFieldsDisplay: boolean;
  fieldsDisplayEdit: boolean;

  selectedVehicle: IVehicle;
  newVehicle: IVehicle;
  vehicles: IVehicle[];

  constructor(private _vehicleService: VehicleService) {
  }

  ngOnInit(): void {
    this.title = 'Vehicle';
    this.newFieldsDisplay = false;
    this.fieldsDisplayEdit = false;
    this.newVehicle = {
      vehicleId: null,
      vehicleName: '',
      vehicleStatus: ''
    };
    this.selectedVehicle = this.newVehicle;
    this.vehicles = [];
  }

  displayNewFields(): void {
    this.newFieldsDisplay = !this.newFieldsDisplay;
    this.newVehicle = {
      vehicleId: null,
      vehicleName: '',
      vehicleStatus: ''
    }
  }

  displayEditFields(vehicle: IVehicle): void {
    if (!this.fieldsDisplayEdit) {
      this.fieldsDisplayEdit = !this.fieldsDisplayEdit;
    }
    this.selectedVehicle = Object.assign({}, vehicle);
  }

  undoDisplayEditFields(): void {
    this.fieldsDisplayEdit = !this.fieldsDisplayEdit;
  }

  addNewVehicle(newVehicle: IVehicle): void {
    this._vehicleService.postVehicle(newVehicle)
      .subscribe(data => this.search(this.vehicleParam));
    this.ngOnInit();
    alert('Vehicle Added successfully');
  }

  updateVehicle(vehicle: IVehicle): void {
    this._vehicleService.putVehicle(vehicle)
      .subscribe(data => this.search(this.vehicleParam));
    alert('Vehicle Update Successful');
  }

  removeVehicle(value: number): void {
    if (confirm('Are you sure you want to delete this vehicle?')) {
      this._vehicleService.deleteVehicle(value)
        .subscribe(data => this.vehicles.length < 2 ?
          this.ngOnInit() : this.search(this.vehicleParam));
    } else {
    }
  }

  searchAllVehicles(): void {
    this._vehicleService.getAllVehicles()
      .subscribe(data => this.vehicles = data);
  }

  searchVehicleById(searchParam: number): void {
    this._vehicleService.getVehicleById(searchParam)
      .subscribe(data => this.vehicles = data);
  }

  searchVehicleByName(searchParam: string): void {
    this._vehicleService.getVehicleByName(searchParam)
      .subscribe(data => this.vehicles = data);
  }

  search(vehicleParam: any): void {
    if (vehicleParam == null) {
      this.searchAllVehicles();
    } else if (vehicleParam.match(/^[0-9]+$/) != null) {
      this.searchVehicleById(vehicleParam);
    } else {
      this.searchVehicleByName(vehicleParam);
    }
    this.ngOnInit();
  }
}
