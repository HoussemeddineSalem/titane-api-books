package dev.titane.apibooks.errors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorResponses implements IBadRequestError {
    NO_BOOKS_FOUND("NO_BOOKS_FOUND");
    private final String message;


    @Override
    public String getMessage() {
        return message;
    }

}
