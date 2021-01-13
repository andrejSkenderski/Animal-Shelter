package mk.finki.ukim.bp.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)

public class VeterinarenCentarNotFound  extends RuntimeException {
    public VeterinarenCentarNotFound(Integer id) {
        super(String.format("Veterinaren Centar with id: %d was not found", id));
    }
}
