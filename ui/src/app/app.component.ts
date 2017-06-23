import { Component } from '@angular/core';

import { RouteService } from './route/route.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [RouteService]
})
export class AppComponent {
  title = 'My Tracker Application';
}
