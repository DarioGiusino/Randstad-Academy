import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, finalize } from 'rxjs';
import { LoaderService } from '../services/loader.service';

@Injectable()
export class LoaderInterceptor implements HttpInterceptor {
  constructor(private loaderService: LoaderService) {}

  // Funzione che intercetta tutte le richieste HTTP
  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    this.loaderService.show(); // Mostra il loader prima di eseguire la richiesta

    // Prosegue con la richiesta e nasconde il loader quando la richiesta è completata
    return next.handle(req).pipe(finalize(() => this.loaderService.hide()));
  }
}
