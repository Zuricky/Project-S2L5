package it.epicode.model;
import lombok.Getter;

@Getter
public class Rivista extends ElementoCatalogo {
    public enum Periodicita {SETTIMANALE, MENSILE, SEMESTRALE}

    private Periodicita periodicita;
    public Rivista(String isbn, String titolo, int numeroPagine, int annoPubblicazione, Periodicita periodicita) {
        super(isbn, titolo, numeroPagine, annoPubblicazione);
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Periodicita='" + periodicita + '\'';
    }
}
