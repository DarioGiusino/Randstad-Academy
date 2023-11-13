import { Injectable } from '@angular/core';
import { ApiService } from 'src/app/core/services/api.service';

@Injectable()
export class ProfileService {
  // Injecting ApiService to handle API requests
  constructor(private api: ApiService) {}

  // Method to create a new user
  createUser(params) {
    return this.api.createUser(params);
  }

  // Method to update user details
  updateUser(params) {
    return this.api.updateUser(params);
  }

  // Method to fetch user details by ID
  getUser(id) {
    return this.api.getUser(id);
  }

  // Method to delete a user by ID
  deleteUser(id) {
    return this.api.deleteUser(id);
  }
}
