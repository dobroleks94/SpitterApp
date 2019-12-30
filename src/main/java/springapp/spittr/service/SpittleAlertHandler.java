package springapp.spittr.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import springapp.spittr.domain.Spittle;


@Component
public class SpittleAlertHandler {

    @JmsListener(destination = "spitter.queue")
    public void handleSpittleAlert(Spittle spittle){
        System.out.println("New spittle form " + spittle.getSpitter().getUsername() + ":\n" + "\"" + spittle.getMessage() + "\"");
    }
}
