package springapp.spittr.config;


import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.CXFService;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import springapp.spittr.domain.Spitter;
import springapp.spittr.service.SpitterService;
import springapp.spittr.service.SpitterServiceImpl;
import sun.security.provider.ConfigFile;

import javax.xml.ws.Endpoint;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"springapp.spittr"},
        excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {


    @Bean public SimpleJaxWsServiceExporter jaxWsExporter(){
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://192.168.56.1:8090/services/");
        return exporter;
    }

    @Bean public ServletRegistrationBean registerCXF(){
        return new ServletRegistrationBean(new CXFServlet(), "/services/*");
    }

//    @Bean("cxf")
//    public Bus bus(){
//        return new SpringBus();
//    }
//
//    @Bean public Endpoint emploeeEndpoint(SpitterService service){
//        EndpointImpl endpoint = new EndpointImpl(bus(), service);
//        endpoint.publish("http://192.168.238.3:8090/services/SpitterService");
//        return endpoint;
//    }

//    @Bean
//    public RmiServiceExporter rmiExporter(SpitterService spitterService){
//        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
//        rmiServiceExporter.setService(spitterService);
//        rmiServiceExporter.setServiceName("SpitterService");
//        rmiServiceExporter.setServiceInterface(SpitterService.class);
//        rmiServiceExporter.setServicePort(2000);
//        return rmiServiceExporter;
//    }
//
//    @Bean
//    public HttpInvokerServiceExporter httpExporter(SpitterService service){
//        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
//        exporter.setService(service);
//        exporter.setServiceInterface(SpitterService.class);
//        return exporter;
//    }
//
//
//    @Bean
//    public HandlerMapping handler() {
//        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
//        Properties mappings = new Properties();
//        mappings.setProperty("/remote",
//                "httpExporter");
//        mapping.setMappings(mappings);
//        return mapping;
//    }

}
