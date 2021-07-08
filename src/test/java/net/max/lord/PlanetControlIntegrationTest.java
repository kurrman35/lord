package net.max.lord;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
 //import ru.sysout.springbootrest.exception.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
//import net.max.lord.Planet;
import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.MatcherAssert.assertThat;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PlanetControlIntegrationTest {

	  @Autowired
	  private TestRestTemplate restTemplate;
	  
	 
	  @Autowired
	  private PlanetService planetService;
	  
	  @Autowired
	  private LordService lordService;
	
      @Test
		public void postPlanet()  throws URISyntaxException {
		   	
		  	 Planet planet=createTestPlanet("Земля");
	 		  HttpEntity<Planet> entity = new HttpEntity<Planet>(planet);
	ResponseEntity<Planet> response =
		 		   restTemplate.postForEntity("/gr",entity, Planet.class);
	//System.out.println("response1.getStatusCode LLL()  ===  "+response.getStatusCode());		
	
 	  assertThat(response.getStatusCode(), is(HttpStatus.OK));		
     assertThat(response.getBody(), is(notNullValue()));
     assertThat(response.getBody().getName(), is("Земля"));
     
   //  assertThat(response.getBody().getLord().getName(), is("Николай"));
 	
	   }	  
      
	 	private Planet createTestPlanet(String name ) {
			Planet emp = new Planet( );
			Lord l=new Lord("Николай");
			lordService.saveOrUpdate(l);		
		 	emp.setName(name);emp.setLord(l);
		 //	planetService.planetRepository.save(emp);
			return  emp;
		}

}
