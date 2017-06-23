import {Component, OnInit} from '@angular/core';

import {IRoute} from './route';
import {RouteService} from './route.service';

@Component({
  selector: 'app-route',
  templateUrl: './route.component.html',
  styleUrls: ['./route.component.css']
})

export class RouteComponent implements OnInit {
  title: string;
  newRouteField: boolean;
  routeParam: any;
  errorMessage: string;
  newRoute: IRoute;
  routes: IRoute[];

  constructor(private _routeService: RouteService) {
  }

  ngOnInit(): void {
    this.title = 'Route';
    this.newRouteField = false;
    this.newRoute = {
      routeId: null,
      routeName: '',
      startLocation: '',
      endLocation: '',
      routeLength: null,
      routeDuration: null
    }
    this.routes = [];
  }

  newRouteFieldsDisplay(): void {
    this.newRouteField = !this.newRouteField;
    this.newRoute = {
      routeId: null,
      routeName: '',
      startLocation: '',
      endLocation: '',
      routeLength: null,
      routeDuration: null
    }
  }

  saveRoute(): void {
    console.log(this.newRoute);
    this._routeService.postRoute(this.newRoute);
    this.newRouteFieldsDisplay();
  }

  searchAllRoutes(): void {
    this._routeService.getAllRoutes()
      .subscribe(data => this.routes = data);
  }

  searchRouteById(value: number): void {
    this._routeService.getRouteById(value)
      .subscribe(data => this.routes = data,
        error => this.errorMessage = <any> error);
  }

  searchRouteByName(value: string): void {
    this._routeService.getRouteByName(value)
      .subscribe(data => this.routes = data);
  }

  removeRoute(value: number): void {
    this._routeService.deleteRoute(value)
      .subscribe(data => this.routes.length < 2 ?
        this.ngOnInit() : this.search(this.routeParam));
  }

  search(routeParam: any): void {
    if (routeParam == null) {
      this.searchAllRoutes();
    } else if (routeParam.match(/^[0-9]+$/) != null) {
      this.searchRouteById(routeParam);
    } else {
      this.searchRouteByName(routeParam);
    }
  }
}
