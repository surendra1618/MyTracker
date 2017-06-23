import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';

import 'rxjs/add/operator/map';

import {IRoute} from './route';

@Injectable()
export class RouteService {
  private _routeUrl = 'http://localhost:8090/my-tracker/route/';

  constructor(private _http: Http) {
  }

  postRoute(value: IRoute): void {
    // console.log('Inside Service, IRoute Input: ' + value);
    // this._http.post(this.routeUrl)
  }

  getAllRoutes(): Observable<IRoute[]> {
    return this._http.get(this._routeUrl)
      .map((response: Response) => response.json().routes);
  }

  getRouteById(routeId: number): Observable<IRoute[]> {
    return this._http.get(this._routeUrl + routeId)
      .map((response: Response) => response.json().routes);
  }

  getRouteByName(routeName: string): Observable<IRoute[]> {
    return this._http.get(this._routeUrl + 'name?searchByName=' + routeName)
      .map((response: Response) => response.json().routes);
  }

  deleteRoute(routeId: number): Observable<Response> {
    return this._http.delete(this._routeUrl + routeId);
  }
}
