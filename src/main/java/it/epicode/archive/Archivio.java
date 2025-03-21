package it.epicode.archive;
import it.epicode.exceptions.DuplicatoISBNException;
import it.epicode.exceptions.ElementoNonTrovatoException;
import it.epicode.model.ElementoCatalogo;
import it.epicode.model.Libro;
import it.epicode.model.Rivista;
import java.util.*;
import java.util.stream.Collectors;


public class Archivio {
    private Map<String, ElementoCatalogo> catalogo = new HashMap<>();

    public void aggiungiElemento(ElementoCatalogo e) throws DuplicatoISBNException {
        if (catalogo.containsKey(e.getIsbn())) {
            throw new DuplicatoISBNException();
        }
        catalogo.put(e.getIsbn(), e);
    }

    public ElementoCatalogo ricercaIsbn(String isbn) throws ElementoNonTrovatoException {
        if (!catalogo.containsKey(isbn)) {
            throw new ElementoNonTrovatoException();
        }
        return catalogo.get(isbn);
    }

    public void rimuoviElementoIsbn(String isbn) throws ElementoNonTrovatoException {
        if (!catalogo.containsKey(isbn)) {
            throw new ElementoNonTrovatoException();
        }
        catalogo.remove(isbn);

    }

    public List<ElementoCatalogo> ricercaAnno(String anno) throws  NumberFormatException {
        return catalogo.values().stream()
                .filter(e -> e.getAnnoPubblicazione() == Integer.parseInt(anno))
                .collect(Collectors.toList());
    }

    public List<ElementoCatalogo> ricercaAutore(String autore) {
        return catalogo.values().stream()
                .filter(e -> e instanceof Libro)
                .map(e -> (Libro) e)
                .filter(e -> e.getAutore().equalsIgnoreCase(autore))
                .collect(Collectors.toList());
    }

    public void aggiornaElemento(String isbn, ElementoCatalogo e) throws ElementoNonTrovatoException {
        if (!catalogo.containsKey(isbn)) {
            throw new ElementoNonTrovatoException();
        }
        catalogo.put(isbn, e);
    }

    public void stampaStatistiche() {
        long totaleLibri = catalogo.values().stream()
                .filter(e -> e instanceof Libro)
                .count();
        long totaleRiviste = catalogo.values().stream()
                .filter(e -> e instanceof Rivista)
                .count();
        OptionalInt maxPagine = catalogo.values().stream()
                .mapToInt(ElementoCatalogo::getNumeroPagine)
                .max();
        double mediaPagine = catalogo.values().stream()
                .mapToInt(ElementoCatalogo::getNumeroPagine)
                .average()
                .orElse(0.0);

        System.out.println("Totale libri: " + totaleLibri);
        System.out.println("Totale riviste: " + totaleRiviste);
        maxPagine.ifPresent(pagine -> System.out.println("Libro con più pagine: " + pagine));
        System.out.println("Media pagine: " + mediaPagine);
    }
}

