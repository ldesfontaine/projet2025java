package com.arena.exceptions;

/**
 * Exception levée lorsqu'un choix invalide est effectué.
 */
public class InvalidChoiceException extends Exception {
    /**
     * Construit une exception avec un message.
     *
     * @param msg Le message d'erreur.
     */
    public InvalidChoiceException(String msg) { super(msg); }
}