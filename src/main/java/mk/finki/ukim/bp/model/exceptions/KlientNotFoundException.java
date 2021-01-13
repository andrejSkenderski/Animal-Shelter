package mk.finki.ukim.bp.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)

public class KlientNotFoundException  extends RuntimeException {
    public KlientNotFoundException(String embg) {
        super(String.format("Klient with embg: %s was not found", embg));
    }
}
