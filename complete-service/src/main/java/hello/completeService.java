package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class completeService {
    public static void main(String[] args) {
        SpringApplication.run(completeService.class, args);
    }

    @RequestMapping("/complete")
    public String complete() {
        return "Hello Docker World from Complete";
    }


    @RequestMapping("/getFromInitial")
    public String getFromInitial() {
         return "getFromInitial";
    }


}
