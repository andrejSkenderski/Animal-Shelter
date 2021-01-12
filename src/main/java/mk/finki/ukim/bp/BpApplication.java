package mk.finki.ukim.bp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class BpApplication {

    public static void main(String[] args) {
        SpringApplication.run(BpApplication.class, args);
    }

}
