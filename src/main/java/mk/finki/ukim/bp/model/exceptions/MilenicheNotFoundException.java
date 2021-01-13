package mk.finki.ukim.bp.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)

public class MilenicheNotFoundException  extends RuntimeException {
    public MilenicheNotFoundException(Integer id) {
        super(String.format("Klient with id: %d was not found", id));
    }
}
