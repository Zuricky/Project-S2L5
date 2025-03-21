package it.epicode.model;
import lombok.Getter;

// classe astratta, isbn (String), titolo (String), numeroPagine (int), annoPubblicazione (int)
@Getter
public abstract class ElementoCatalogo {
    private String isbn;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;

    public ElementoCatalogo(String isbn, String titolo, int numeroPagine, int annoPubblicazione) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

  @Override
    public String toString() {
        return "ElementoCatalogo{" +
                "ISBN='" + isbn + '\'' +
                ", Titolo='" + titolo + '\'' +
                ", Anno=" + annoPubblicazione +
                ", Pagine=" + numeroPagine +
                '}';
    }
}