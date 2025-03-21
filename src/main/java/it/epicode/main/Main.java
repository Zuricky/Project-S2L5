package it.epicode.main;
import it.epicode.archive.Archivio;
import it.epicode.exceptions.DuplicatoISBNException;
import it.epicode.model.Libro;
import it.epicode.model.Rivista;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DuplicatoISBNException {
        Archivio archivio = new Archivio();
        Scanner scanner = new Scanner(System.in);

        Libro libro1 = new Libro("12345", "Il Nome della Rosa", 512, 1980, "Umberto Eco", "Giallo");
        Libro libro2 = new Libro("123", "Il Piccolo Principe", 93, 1943, "Antoine de Saint-Exupéry", "Fiaba");
        Libro libro3 = new Libro("54321", "Il Signore degli Anelli", 1200, 1954, "J.R.R. Tolkien", "Fantasy");
        // Libro libro4 = new Libro("54321", "Il Signore degli Anelli", 1200, 1954, "J.R.R. Tolkien", "Fantasy");
        Rivista rivista1 = new Rivista("1234", "National Geographic",420, 2022, Rivista.Periodicita.MENSILE);
        Rivista rivista2 = new Rivista("9012", "The New Yorker", 520, 2022, Rivista.Periodicita.SETTIMANALE);
        Rivista rivista3 = new Rivista("7890", "Wired", 270, 2022, Rivista.Periodicita.SEMESTRALE);
        // Rivista rivista4 = new Rivista("7890", "Wired", 270, 2022, Rivista.Periodicita.SEMESTRALE);

        archivio.aggiungiElemento(libro1);
        archivio.aggiungiElemento(libro2);
        archivio.aggiungiElemento(libro3);
        // archivio.aggiungiElemento(libro4);
        archivio.aggiungiElemento(rivista1);
        archivio.aggiungiElemento(rivista2);
        archivio.aggiungiElemento(rivista3);
        // archivio.aggiungiElemento(rivista4);

        while (true) {
            System.out.println("1. Aggiungi libro");
            System.out.println("2. Aggiungi rivista");
            System.out.println("3. Ricerca per ISBN");
            System.out.println("4. Rimuovi elemento per ISBN");
            System.out.println("5. Ricerca per anno di pubblicazione");
            System.out.println("6. Ricerca per autore");
            System.out.println("7. Aggiorna elemento per ISBN");
            System.out.println("8. Stampa statistiche");
            System.out.println("0. Esci");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (scelta) {

                    case 0:
                        return;

                    case 1:
                        System.out.println("ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.println("Titolo: ");
                        String titolo = scanner.nextLine();
                        System.out.println("Anno: ");
                        int anno = scanner.nextInt();
                        System.out.println("Numero pagine: ");
                        int pagine = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Autore: ");
                        String autore = scanner.nextLine();
                        System.out.println("Genere: ");
                        String genere = scanner.nextLine();
                        archivio.aggiungiElemento(new Libro(isbn, titolo, anno, pagine, autore, genere));
                        break;

                    case 2:
                        System.out.println("ISBN: ");
                        String isbnR = scanner.nextLine();
                        System.out.println("Titolo: ");
                        String titoloR = scanner.nextLine();
                        System.out.println("Anno: ");
                        int annoR = scanner.nextInt();
                        System.out.println("Numero pagine: ");
                        int pagineR = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Periodicità (SETTIMANALE, MENSILE, SEMESTRALE): ");
                        Rivista.Periodicita periodicita = Rivista.Periodicita.valueOf(scanner.nextLine().toUpperCase());
                        archivio.aggiungiElemento(new Rivista(isbnR, titoloR, annoR, pagineR, periodicita));
                        break;

                    case 3:
                        System.out.println("ISBN: ");
                        System.out.println(archivio.ricercaIsbn(scanner.nextLine()));
                        break;

                    case 4:
                        System.out.println("ISBN da rimuovere: ");
                        archivio.rimuoviElementoIsbn(scanner.nextLine());
                        break;

                    case 5:
                        System.out.println("Anno: ");
                        System.out.println(archivio.ricercaAnno(String.valueOf(scanner.nextInt())));
                        break;

                    case 6:
                        System.out.println("Autore: ");
                        System.out.println(archivio.ricercaAutore(scanner.nextLine()));
                        break;

                    case 7:
                        System.out.println("ISBN da aggiornare: ");
                        String isbnAgg = scanner.nextLine();
                        System.out.println("Titolo: ");
                        String titoloAgg = scanner.nextLine();
                        System.out.println("Anno: ");
                        int annoAgg = scanner.nextInt();
                        System.out.println("Numero pagine: ");
                        int pagineAgg = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Autore: ");
                        String autoreAgg = scanner.nextLine();
                        System.out.println("Genere: ");
                        String genereAgg = scanner.nextLine();
                        archivio.aggiornaElemento(isbnAgg, new Libro(isbnAgg, titoloAgg, annoAgg, pagineAgg, autoreAgg, genereAgg));
                        break;

                        case 8:
                            archivio.stampaStatistiche();
                            break;
                }
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
    }
}