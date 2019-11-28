package springapp.spittr.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springapp.spittr.domain.Spitter;
import springapp.spittr.data.SpitterRepository;

import javax.servlet.http.Part;
import javax.validation.Valid;
import java.security.Principal;
import java.sql.SQLException;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository){
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model){
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@Valid Spitter spitter, Errors error, RedirectAttributes model){
        if(error.hasErrors())
            return "registerForm";

            spitterRepository.save(spitter);
            spitterRepository.addUser(spitter.getUsername(), new BCryptPasswordEncoder().encode(spitter.getPassword()));
            model.addAttribute("username", spitter.getUsername());
            model.addFlashAttribute("spitter", spitter);

        return "redirect:/login";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model){
        if(!model.containsAttribute("spitter"))
            model.addAttribute(spitterRepository.findByUsername(username));
        return "profile";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String showSearch(){
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchByMatch(@RequestParam(value = "ssearch") String match, RedirectAttributes model){
        model.addAttribute("ssearch", match);
        model.addFlashAttribute("spitters", spitterRepository.findAllByFirstNameContainingOrLastNameContainingOrUsernameContaining(match,match,match));
        return "redirect:/spitter/search_{ssearch}";
    }

    @RequestMapping(value = "/search_{ssearch}", method = RequestMethod.GET)
    public String showSpitters(@PathVariable String ssearch, Model model){
        if(!model.containsAttribute("spitters"))
            model.addAttribute(spitterRepository.findAllByFirstNameContainingOrLastNameContainingOrUsernameContaining(ssearch,ssearch,ssearch));
        return "spitters";
    }
}
