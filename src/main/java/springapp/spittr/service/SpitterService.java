package springapp.spittr.service;

import springapp.spittr.domain.Spitter;
import springapp.spittr.domain.Spittle;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;


@WebService(name = "SpitterService", targetNamespace = "http://service.spittr.springapp/")
public interface SpitterService {
//    List<Spittle> getRecentSpittles(int count);
//    void saveSpittle(Spittle spittle);
//    void saveSpitter(Spitter spitter);
//    void startFollowing(Spitter folowee, Spitter folower);
//    List<Spittle> getSpittlesForSpitter(Spitter username);
//    List<Spittle> getSpittlesForSpitter(String username);
//    Spittle getSpitter(long id);
//    Spittle getSpittleById(long id);
//    void deleteSpittle (long id);
//    List<Spitter> getAllSpitters();

    @WebMethod
    Spitter getSpitter(String username);
    @WebMethod
    List<Spittle> getSpittlesForSpitter(Spitter username);


}
