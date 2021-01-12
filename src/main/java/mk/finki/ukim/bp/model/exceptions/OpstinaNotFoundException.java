package mk.finki.ukim.bp.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class OpstinaNotFoundException extends RuntimeException{

    public OpstinaNotFoundException(int id) {
        super(String.format("Opstina with id: %d was not found", id));
    }
}