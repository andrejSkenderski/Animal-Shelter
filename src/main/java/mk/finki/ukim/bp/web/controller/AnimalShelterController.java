package mk.finki.ukim.bp.web.controller;


import mk.finki.ukim.bp.model.Klient;
import mk.finki.ukim.bp.model.Mileniche;
import mk.finki.ukim.bp.model.Opstina;
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
        List<Mileniche> milenichinja = this.milenicheService.listAll();
        model.addAttribute("milenichinja", milenichinja);

        List<Klient> klienti = this.klientService.listAll();
        model.addAttribute("klienti", klienti);

        model.addAttribute("bodyContent", "home");

        return "home";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteKlient(@PathVariable String id) {
        this.klientService.deleteById(id);
        return "redirect:/home";
    }


    @GetMapping("/add-form")
    public String addKlientPage(Model model) {
        List<Klient> klienti = this.klientService.listAll();
        List<Opstina> opstini = this.opstinaService.listAll();
        model.addAttribute("klienti", klienti);
        model.addAttribute("opstini", opstini);

        return "add-klient";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditKlientPage(@PathVariable String id, Model model) {
        if (this.klientService.findByEmbg(id).isPresent()) {
            Klient klient = this.klientService.findByEmbg(id).get();
            List<Opstina> opstini = this.opstinaService.listAll();
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

        this.klientService.addKlient(embg, ime, prezime, adresa, opstina);


        return "redirect:/home";
    }

    @GetMapping("/list-pets/{id}")
    public String listMilenichinja(@PathVariable String id, Model model) {
        if (this.klientService.findByEmbg(id).isPresent()) {
            Klient klient = this.klientService.findByEmbg(id).get();
            List<Mileniche> milenichinja = this.milenicheService.listAll();
            model.addAttribute("klient", klient);
            model.addAttribute("milenichinja", milenichinja);
            return "list-pets";
        }

        return "redirect:/home?error=KlientNotFound";

    }

    @GetMapping("/vdomi-mileniche/{embg}/{id}")
    public String vdomiMileniche(@PathVariable String embg, @PathVariable Integer id, Model model) {
        if (this.klientService.findByEmbg(embg).isPresent()) {
            if (this.milenicheService.findById(id).isPresent()) {
                Mileniche mileniche = this.milenicheService.findById(id).get();
                model.addAttribute("mileniche", mileniche);
                this.milenicheService.updateVdomenoMileniche(id, embg);
                return "redirect:/home";
            }
            return "redirect:/home?error=MilenicheNotFound";
        }
        return "redirect:/home?error=KlientNotFound";
    }
    

//    @GetMapping("/pregledaj-mileniche/{id}")
//    public String pregledajMileniche (@PathVariable Integer id, Model model){
//        if (this.milenicheService.findById(id).isPresent()){
//            Mileniche mileniche = this.milenicheService.findById(id).get();
//            model.addAttribute("mileniche", mileniche);
//            return "pregledaj-mileniche";
//        }
//        return "redirect:/home?error=MilenicheNotFound";
//    }




}
