import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/observable';

import 'rxjs/add/operator/map';

import {IVehicle} from './vehicle';

@Injectable()
export class VehicleService {
  private _vehicleUrl = 'http://localhost:8090/my-tracker/vehicle/';

  constructor(private _http: Http) {
  }

  postVehicle(value: IVehicle): Observable<Response> {
    console.log('inside postVehicle of service: ');
    console.log(value);
    return this._http.post(this._vehicleUrl, value);
  }

  putVehicle(value: IVehicle): Observable<Response> {
    console.log('inside putVehicle of service');
    console.log(value);
    return this._http.put(this._vehicleUrl, value);
  }

  deleteVehicle(value: number): Observable<Response> {
    alert('Vehicle Deleted');
    return this._http.delete(this._vehicleUrl + value);
  }

  getAllVehicles(): Observable<IVehicle[]> {
    return this._http.get(this._vehicleUrl)
      .map((response: Response) => response.json().vehicles);
  }

  getVehicleById(value: number): Observable<IVehicle[]> {
    return this._http.get(this._vehicleUrl + value)
      .map((response: Response) => response.json().vehicles);
  }

  getVehicleByName(value: string): Observable<IVehicle[]> {
    return this._http.get(this._vehicleUrl + 'name?searchVehicle=' + value)
      .map((response: Response) => response.json().vehicles)
  }
}
