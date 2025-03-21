package it.epicode.exceptions;

public class ElementoNonTrovatoException extends Exception {
    public ElementoNonTrovatoException() {
        super("Elemento non trovato nel catalogo");
    }
}
