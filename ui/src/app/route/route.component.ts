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
  routeParam: any;

  newFieldsDisplay: boolean;
  fieldsDisplayEdit: boolean;

  newRoute: IRoute;
  selectedRoute: IRoute;
  routes: IRoute[];

  constructor(private _routeService: RouteService) {
  }

  ngOnInit(): void {
    this.title = 'Route';
    this.newFieldsDisplay = false;
    this.fieldsDisplayEdit = false;
    this.newRoute = {
      routeId: null,
      routeName: '',
      startLocation: '',
      endLocation: '',
      routeLength: null,
      routeDuration: null
    }
    this.selectedRoute = this.newRoute;
    this.routes = [];
  }

  displayNewRouteFields(): void {
    this.newFieldsDisplay = !this.newFieldsDisplay;
    this.newRoute = {
      routeId: null,
      routeName: '',
      startLocation: '',
      endLocation: '',
      routeLength: null,
      routeDuration: null
    }
  }

  displayEditFields(route: IRoute): void {
    if (!this.fieldsDisplayEdit) {
      this.fieldsDisplayEdit = !this.fieldsDisplayEdit;
    }
    this.selectedRoute = Object.assign({}, route);
  }

  undoDisplayEditFields(): void {
    this.fieldsDisplayEdit = !this.fieldsDisplayEdit;
    this.selectedRoute = {
      routeId: null,
      routeName: '',
      startLocation: '',
      endLocation: '',
      routeLength: null,
      routeDuration: null
    }
  }

  addRoute(value: IRoute): void {
    this._routeService.postRoute(value)
      .subscribe(data => this.search(this.routeParam));
    alert('Route Added successfully');
  }

  updateRoute(route: IRoute): void {
    this._routeService.putRoute(route)
      .subscribe(data => this.search(this.routeParam));
    alert('Route Update Successful');
  }

  removeRoute(value: number): void {
    if (confirm('Are you sure you want to delete this vehicle?')) {
      this._routeService.deleteRoute(value)
        .subscribe(data => this.routes.length < 2 ?
          this.ngOnInit() : this.search(this.routeParam));
    } else {
    }
  }

  searchAllRoutes(): void {
    this._routeService.getAllRoutes()
      .subscribe(data => this.routes = data);
  }

  searchRouteById(value: number): void {
    this._routeService.getRouteById(value)
      .subscribe(data => this.routes = data);
  }

  searchRouteByName(value: string): void {
    this._routeService.getRouteByName(value)
      .subscribe(data => this.routes = data);
  }

  search(routeParam: any): void {
    if (routeParam == null || routeParam === '') {
      this.searchAllRoutes();
    } else if (routeParam.match(/^[0-9]+$/) != null) {
      this.searchRouteById(routeParam);
    } else {
      this.searchRouteByName(routeParam);
    }
    this.ngOnInit();
  }
}
