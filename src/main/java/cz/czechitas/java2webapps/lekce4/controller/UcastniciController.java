package cz.czechitas.java2webapps.lekce4.controller;

import cz.czechitas.java2webapps.lekce4.entity.Ucastnik;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller()
@RequestMapping("/ucastnici")
public class UcastniciController {
    private List<Ucastnik> ucastnici = List.of(
            new Ucastnik("Medvídek", "Pů", "kmen", "https://www.sablonynazed.cz/576-large_default/medvidek-pu-01.jpg"),
            new Ucastnik("Čarodejnice", "Malá", "neuvedeno", "https://koralkykomponenty.cz/46760-thickbox_default/diamantove-malovani-vila-carodejnice-c230.jpg")
    );

    @GetMapping("/")
    public ModelAndView seznam() {

        ModelAndView modelAndView = new ModelAndView("/ucastnici/index");
        modelAndView.addObject("ucastnici", ucastnici);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/ucastnici/detail");
        modelAndView.addObject("ucastnik", ucastnici.get(id));
        return modelAndView;

    }
}