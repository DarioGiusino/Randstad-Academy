import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { BehaviorSubject, map } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  senderId = new BehaviorSubject<string>(sessionStorage.getItem('senderId'));
  // senderId = new BehaviorSubject<string>('');

  utilsId;

  constructor(private api: ApiService, private router: Router) {}

  getUsers() {
    return this.api.getUsers().pipe(
      map((user) => {
        const ids = Object.keys(user);
        const res = ids.map((id) => {
          return {
            ...user[id],
            id: id,
          };
        });
        return res.filter((user) => !user?.isLogged);
      })
    );
  }

  getAllUsers() {
    return this.api.getUsers().pipe(
      map((user) => {
        const ids = Object.keys(user);
        const res = ids.map((id) => {
          return {
            ...user[id],
            id: id,
          };
        });
        return res;
      })
    );
  }

  setSession(id: string) {
    this.getAllUsers().subscribe((users) => {
      const userLogged = users.find((user) => user.id === id);

      if (userLogged) {
        userLogged.isLogged = true;
        this.api.updateUser(userLogged).subscribe(() => {
          this.senderId.next(id);
          sessionStorage.setItem('senderId', id);
          // this.senderId.next(sessionStorage.getItem('senderId'));
        });
      } else {
        console.error('utente non trovato');
      }
    });
  }

  resetSession() {
    this.senderId.subscribe({ next: (res) => (this.utilsId = res) });

    this.getAllUsers().subscribe((users) => {
      // const userLogged = users.find((user) => user.id === this.utilsId);
      const userLogged = users.find(
        (user) => user.id === sessionStorage.getItem('senderId')
      );

      if (userLogged) {
        userLogged.isLogged = false;
        this.api.updateUser(userLogged).subscribe(() => {
          this.senderId.next('');
          sessionStorage.clear();
          this.router.navigate(['auth']);
        });
      } else {
        console.error('utente non trovato');
      }
    });
  }
}
