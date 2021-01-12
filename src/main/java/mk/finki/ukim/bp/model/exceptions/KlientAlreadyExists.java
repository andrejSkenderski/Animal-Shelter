package mk.finki.ukim.bp.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class KlientAlreadyExists extends RuntimeException{

    public KlientAlreadyExists(String embg) {
        super(String.format("Client with embg: %d already exists.", embg));
    }
}