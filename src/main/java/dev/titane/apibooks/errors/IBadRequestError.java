package dev.titane.apibooks.errors;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(
        shape = JsonFormat.Shape.OBJECT
)
public interface IBadRequestError {

    String getMessage();
}