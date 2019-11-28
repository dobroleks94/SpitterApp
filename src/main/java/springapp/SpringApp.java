package springapp;

import org.hibernate.type.LocaleType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springapp.spittr.service.SpitterServiceImpl;

import javax.xml.ws.Endpoint;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

@SpringBootApplication
public class SpringApp {
    public static void main(String[] args) throws RemoteException {
        SpringApplication.run(SpringApp.class, args);
    }


}
