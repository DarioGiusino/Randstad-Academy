import { Directive, Input, ElementRef, OnInit } from '@angular/core';

@Directive({
  selector: '[statusIndicator]', // Selettore della direttiva
})
export class StatusIndicatorDirective implements OnInit {
  @Input() statusIndicator: boolean | undefined; // Proprietà di input per la direttiva

  constructor(private el: ElementRef) {} // Ottiene l'elemento su cui viene applicata la direttiva

  ngOnInit() {
    // Definizione del testo in base al booleano passato
    const statusText = this.statusIndicator ? 'ONLINE' : 'OFFLINE';

    // Definizione del colore in base al booleano passato
    const color = this.statusIndicator ? 'green' : 'red';

    // Assegna il testo e il colore all'elemento su cui è applicata la direttiva
    this.el.nativeElement.innerText = statusText;
    this.el.nativeElement.style.color = color;
  }
}
