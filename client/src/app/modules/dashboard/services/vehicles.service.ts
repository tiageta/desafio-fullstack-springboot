import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable, shareReplay } from 'rxjs';
import { Vehicles } from 'src/app/shared/models/vehicle.model';
import { environment } from 'src/environments/environment';

const API = environment.API_URL;

interface VehiclesResponse {
  data: Vehicles;
}

@Injectable({
  providedIn: 'root',
})
export class VehiclesService {
  constructor(private http: HttpClient) {}

  getVehicles(): Observable<Vehicles> {
    return this.http.get<VehiclesResponse>(`${API}/vehicles`).pipe(
      map((response: VehiclesResponse) => response.data), // pluck is deprecated
      shareReplay(1)
    );
  }
}
