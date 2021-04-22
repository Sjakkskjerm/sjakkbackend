package no.ntnu.sjakkskjerm.livegame.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmptyPGNAdvice {

    @ResponseBody
    @ExceptionHandler(EmptyPGNException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String emptyPgnHandler(EmptyPGNException ex) {
        return ex.getMessage();
    }
}
