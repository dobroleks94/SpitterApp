package springapp.spittr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import springapp.spittr.data.SpitterRepository;
import springapp.spittr.domain.Spitter;
import springapp.spittr.domain.Spittle;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

@Component
@WebService(serviceName = "SpitterService",
        portName = "SpitterServicePort",
        targetNamespace = "http://service.spittr.springapp/",
        endpointInterface = "springapp.spittr.service.SpitterService")
//@Service
public class SpitterServiceImpl implements SpitterService {

    @Autowired
    SpitterRepository spitterRepository;


    public SpitterServiceImpl(){}


    @WebMethod
    public Spitter getSpitter(String username) {
        return spitterRepository.findByUsername(username);
    }
    @WebMethod
    public List<Spittle> getSpittlesForSpitter(Spitter username) {
        return username.getSpittleList();
    }

}
