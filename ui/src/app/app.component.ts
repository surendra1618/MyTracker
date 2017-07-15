import {Component} from '@angular/core';

import {RouteService} from './route/route.service';
import {VehicleService} from './vehicle/vehicle.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [RouteService, VehicleService]
})
export class AppComponent {
  title = 'MyTracker';
}
