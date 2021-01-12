package mk.finki.ukim.bp.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class MilenicheAlreadyExists extends RuntimeException{

    public MilenicheAlreadyExists(Integer id) {
        super(String.format("Mileniche with id: %d already exists.", id));
    }
}