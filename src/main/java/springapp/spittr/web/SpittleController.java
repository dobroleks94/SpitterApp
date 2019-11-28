package springapp.spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springapp.spittr.data.SpitterRepository;
import springapp.spittr.domain.Spittle;
import springapp.spittr.data.SpittleRepository;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {


    private static final String MAX_LONG_AS_STRING = "9223372036854775807";
    private SpittleRepository spittleRepository;
    private SpitterRepository spitterRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository, SpitterRepository sr){
        this.spittleRepository = spittleRepository;
        this.spitterRepository =  sr;
    }

    /*@RequestMapping(method = RequestMethod.GET)
    public String spittles(Map model){
        model.put("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittle";
    }*/

    /*@RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showSpittle(@RequestParam("spittle_id") long spittleId, Model model){
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }*/

   /* @RequestMapping(value = "/{spittle_id}", method = RequestMethod.GET)
    public String showSpittle(@PathVariable("spittle_id") long spittle_id, Model model){
        Spittle spittle = spittleRepository.findOne(spittle_id);
        if (spittle == null)
            throw new SpittleNotFoundException();
        model.addAttribute(spittle);
        return "spittle";
    }*/

    @RequestMapping(value = "/{spittle_id}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spittle_id") long spittle_id, Model model){
        Spittle spittle = spittleRepository.findSpittleById(spittle_id).get(0);
        if (spittle == null)
            throw new SpittleNotFoundException();
        model.addAttribute("spittle", spittle);
        return "spittle";
    }


    @RequestMapping(method = RequestMethod.GET)
    public String spittles(
            @RequestParam(value="count", defaultValue = "5") int count, Model model, Principal p){
        /*try{
        spitterRepository.findByUsername(p.getName()).setAuthorized(true);}
        catch (Exception e){}*/
        model.addAttribute(spittleRepository.findOrderedSpittles(count));
        return "spittles";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(SpittleForm spittle, Model model, Principal user) throws DuplicateSpittleException {
        spittleRepository.save(new Spittle(spittle.getMessage(), new Date(), spitterRepository.findByUsername(user.getName())));
        return "redirect:/spittles";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    @PostFilter("filterObject.spitter.username == principal.username")
    public List<Spittle> editSpittle(@RequestParam("id") Long id, Model model){
        return spittleRepository.findSpittleById(id);
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("id") Long id, @RequestParam("message") String message, Model model){
        spittleRepository.updateSpittle(message, id);
        return "redirect:/spittles";
    }







}
