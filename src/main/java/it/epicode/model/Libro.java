package it.epicode.model;
import lombok.Getter;

@Getter
public class Libro extends ElementoCatalogo {
    private String autore;
    private String genere;

    public Libro(String isbn, String titolo, int numeroPagine, int annoPubblicazione, String autore, String genere) {
        super(isbn, titolo, numeroPagine, annoPubblicazione);
        this.autore = autore;
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "Autore='" + autore + '\'' +
                ", Genere='" + genere + '\'' +
                '}';
    }
}