package it.epicode.exceptions;

public class DuplicatoISBNException extends Exception {
    public DuplicatoISBNException() {
        super("ISBN già presente nel catalogo");
    }
}