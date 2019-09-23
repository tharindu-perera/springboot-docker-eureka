package hello;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class RestClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestClient.class);
    public static void main(String[] args) {
        SpringApplication.run(RestClient.class, args);
    }

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(value = "/getInitialService", method = RequestMethod.GET)
    public String getStudents()
    {
        String response = restTemplate.exchange("http://initial-server/initial",
                HttpMethod.GET,null,String.class).getBody();

        LOGGER.info("Response Received as " + response);

        return   response;
    }
    // a fallback method to be called if failure happened
    public String fallback( Throwable hystrixCommand) {
        LOGGER.info("response from Fall back method");
        return "response from Fall back method ";
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}