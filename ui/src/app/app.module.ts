import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/Router'
import {FormsModule} from '@angular/Forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {VehicleComponent} from './vehicle/vehicle.component';
import {RouteComponent} from './route/route.component';
import {ScheduleComponent} from './schedule/schedule.component';
import {HomeComponent} from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    VehicleComponent,
    RouteComponent,
    ScheduleComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
      {
        path: 'home',
        component: HomeComponent
      },
      {
        path: 'route',
        component: RouteComponent
      },
      {
        path: 'vehicle',
        component: VehicleComponent
      },
      {
        path: 'schedule',
        component: ScheduleComponent
      }
    ]),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
