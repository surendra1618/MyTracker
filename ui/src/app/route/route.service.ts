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

  postRoute(value: IRoute): Observable<Response> {
    console.log('Inside Service, IRoute Input: ' + value);
    return this._http.post(this._routeUrl, value);
  }

  putRoute(value: IRoute): Observable<Response> {
    return this._http.put(this._routeUrl, value);
  }

  deleteRoute(routeId: number): Observable<Response> {
    alert('Route Deleted');
    return this._http.delete(this._routeUrl + routeId);
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
    return this._http.get(this._routeUrl + 'name?searchRoute=' + routeName)
      .map((response: Response) => response.json().routes);
  }
}
