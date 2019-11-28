//package springapp.spittr.service;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import springapp.spittr.domain.Spitter;
//import springapp.spittr.domain.Spittle;
//
//import javax.jws.WebMethod;
//import javax.jws.WebService;
//import java.util.List;
//
//@Component
//@WebService(serviceName = "SpitterService")
//public class SpitterWebService {
//
//    @Autowired
//    SpitterService service;
//
//
//    @WebMethod
//    public Spitter getSpitter(String username) {
//        return service.getSpitter(username);
//    }
//
//    @WebMethod
//    public List<Spittle> getSpittlesForSpitter(Spitter username) {
//        return service.getSpittlesForSpitter(username);
//    }
//}
