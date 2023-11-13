import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  getUsers() {
    return this.http.get<any>(`${this.apiUrl}/users.json`);
  }

  getUser(id: string) {
    return this.http.get<any>(`${this.apiUrl}/users/${id}.json`);
  }

  deleteUser(id: string) {
    return this.http.delete<any>(`${this.apiUrl}/users/${id}.json`);
  }

  updateUser(params) {
    if (params.id) {
      return this.http.put<any>(
        `${this.apiUrl}/users/${params.id}.json`,
        params
      );
    } else {
      console.warn('Manca user ID');
    }
  }

  createUser(params) {
    return this.http.post<any>(`${this.apiUrl}/users.json`, params);
  }

  getMessages() {
    return this.http.get(`${this.apiUrl}/messages.json`);
  }
  sendMessage(params) {
    return this.http.post(`${this.apiUrl}/messages.json`, params);
  }

  // Alternativa
  // post(endpoint, params){
  //   return this.http.post(endpoint, params)
  // }
}
