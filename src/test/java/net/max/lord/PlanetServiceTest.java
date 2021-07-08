package net.max.lord;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

//import org.junit.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import    org.springframework.test.web.servlet.MockMvc;
import java.util.Optional;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 
 @SpringBootTest
  @AutoConfigureMockMvc

public class PlanetServiceTest {
	
	@Autowired
	private MockMvc mockMvc;
 
	   @Autowired
	   PlanetService planetService;
	   
	   
	   @MockBean
	    private	PlanetRepository planetRepository;  
		 

	  
	   @Test
			public void getAllPlanet() {
		   List<Planet> data = new ArrayList<Planet>();
			Planet planet=new Planet ();			
		   data.add(planet );
		   planetService.getAllPlanet();
		   Mockito.verify(planetRepository, Mockito.times(1)).findAll( );
		   
		   Mockito.when(planetService.getAllPlanet( )).thenReturn(data);
	   }
			
	  @Test
				public void getAllPlanet2() throws Exception{
		
	 	    this.mockMvc.perform(
		             get("/"))
	 	//  .andDo()
	 	    .andExpect(status().isOk())
	 	    .andExpect(content().string(""));
	   }
		           //  .andExpect(content().json(objectMapper.writeValueAsString
		           //  		(data)));
		   
	 	//	   Mockito.doReturn(data).when(planetRepository).findAll();
		 	
	  
	   @Test
		public void getPlanetByName() {
		   
		   List<Planet> data = new ArrayList<Planet>();
					Planet planet=new Planet ( "Луна",new Lord("Николай"));			
				   data.add(planet );
				
		   Mockito.when(planetService.findByName("Николай")
				   ).thenReturn(data);		   
	   }
	   
	    @Test
		public void saveOrUpdate() {
			Planet planet=new Planet ();
			assertThat(planetService).isNotNull();
			planetService.saveOrUpdate(planet);
		    Mockito.verify(planetRepository, Mockito.times(1)).save(planet);
		    
		//	planetService.delete(planet);
		}
	     
	   
	     @Test
	   public void delete() {
		   Planet planet=new Planet ();
		   assertThat(planetService).isNotNull();
	 
		   planetService.delete(planet);
		   Mockito.verify(planetRepository, Mockito.times(1)).delete(planet);
	    
 	}
	   
	   
	   
	   
}
