package springapp.spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springapp.spittr.data.SpitterRepository;

import java.security.Principal;

@Controller
public class GeneralController {

    private SpitterRepository spitterRepository;


    @Autowired
    public GeneralController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value="/signout")
    public String signout(Principal user){
        spitterRepository.findByUsername(user.getName()).setAuthorized(false);
        return "home";
    }

    @RequestMapping(value = {"/", "/home"})
    public String homePage(Principal user){
        if(user != null)
            spitterRepository.findByUsername(user.getName()).setAuthorized(true);
        return "home";
    }
}
