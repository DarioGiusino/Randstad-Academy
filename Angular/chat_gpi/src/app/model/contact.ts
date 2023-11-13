export class Contact {
  id: number; // Identificatore del contatto (presumibilmente un numero intero)
  number: number; // Numero di telefono del contatto
  prefix: string; // Prefisso del numero di telefono (presumibilmente una stringa)
  type: string; // Tipo di contatto (ad es. 'casa', 'ufficio', 'cellulare', ecc.)
  isActive: boolean; // Indica se il contatto è attivo o meno (true o false)
}
