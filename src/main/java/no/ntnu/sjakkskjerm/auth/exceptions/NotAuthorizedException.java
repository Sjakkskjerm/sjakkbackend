package no.ntnu.sjakkskjerm.auth.exceptions;

public class NotAuthorizedException extends RuntimeException {

    public NotAuthorizedException() {
        super("User is not authorized for this action");
    }
}
