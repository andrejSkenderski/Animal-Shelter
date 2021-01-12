package mk.finki.ukim.bp.web.controller;


import mk.finki.ukim.bp.model.klient;
import mk.finki.ukim.bp.model.mileniche;
import mk.finki.ukim.bp.model.opstina;
import mk.finki.ukim.bp.service.KlientService;
import mk.finki.ukim.bp.service.MilenicheService;
import mk.finki.ukim.bp.service.OpstinaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/home")
public class AnimalShelterController {
    private final KlientService klientService;
    private final MilenicheService milenicheService;
    private final OpstinaService opstinaService;

    public AnimalShelterController(KlientService klientService, MilenicheService milenicheService, OpstinaService opstinaService) {
        this.klientService = klientService;
        this.milenicheService = milenicheService;
        this.opstinaService = opstinaService;
    }

    @GetMapping
    public String getHomePage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<mileniche> milenichinja = this.milenicheService.listAll();
        model.addAttribute("milenichinja", milenichinja);

        List<klient> klienti = this.klientService.listAll();
        model.addAttribute("klienti", klienti);

        model.addAttribute("bodyContent", "home");

        return "home";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteKlient(@PathVariable String id) {
        this.klientService.deleteByEmbg(id);
        return "redirect:/home";
    }


    @GetMapping("/add-form")
    public String addKlientPage(Model model) {
        List<klient> klienti = this.klientService.listAll();
        List<opstina> opstini = this.opstinaService.listAll();
        model.addAttribute("klienti", klienti);
        model.addAttribute("opstini", opstini);

        return "add-klient";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditKlientPage(@PathVariable String id, Model model) {
        if (this.klientService.findByEmbg(id).isPresent()) {
            klient klient = this.klientService.findByEmbg(id).get();
            List<opstina> opstini = this.opstinaService.listAll();
            model.addAttribute("klient", klient);
            model.addAttribute("opstini", opstini);
            return "add-klient";
        }
        return "redirect:/home?error=KlientNotFound";
    }

    @PostMapping("/add")
    public String saveKlient(
            @RequestParam String embg,
            @RequestParam String ime,
            @RequestParam String prezime,
            @RequestParam String adresa,
            @RequestParam Integer opstina) {

            this.klientService.addKlient(embg,ime,prezime,adresa,opstina);


        return "redirect:/home";
    }


}
