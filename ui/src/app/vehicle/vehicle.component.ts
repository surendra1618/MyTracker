import { Component } from '@angular/core';

@Component({
    selector: 'vehicle-app',
    templateUrl: './vehicle.component.html' 
})
export class VehicleComponent {
    title = 'This is app-vehicle';
    vehicleId: number;

    getVehicle(): number {
        return this.vehicleId;
    }
}