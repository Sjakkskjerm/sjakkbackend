package no.ntnu.sjakkskjerm.tournament.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AddGameAdvice {

    @ResponseBody
    @ExceptionHandler(AddGameException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String addGameHandler(AddGameException ex) {
        return ex.getMessage();
    }
}
