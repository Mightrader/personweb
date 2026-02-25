package fr.afpa.personweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

    private final String API_URL = "http://personapi:8080/persons";

    @GetMapping("/")
    public String home(Model model) {

        RestTemplate restTemplate = new RestTemplate();
        Object persons = restTemplate.getForObject(API_URL, Object.class);

        model.addAttribute("persons", persons);

        return "index";
    }
}