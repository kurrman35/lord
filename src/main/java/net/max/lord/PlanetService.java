package net.max.lord;

		import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
		@Service 
		
		public class PlanetService   
		{ 
			
		@Autowired  
		PlanetRepository planetRepository;  
	
			//getting all student records  
		public List<Planet> getAllPlanet()   
		{  
		List<Planet> planets = new ArrayList<Planet>();  
		planetRepository.findAll().forEach(Planet -> planets.add(Planet));  
		return planets; 
		
		}  
	
		List<Planet> findByName(String name){
		
		 return planetRepository.findByLord_NameLikeIgnoreCase(name)	;
		}
	
		//getting a specific record  
	 	
		public void saveOrUpdate(Planet planet)   
		{  
		planetRepository.save(planet);  
		}  
	
		public void insert(Planet planet)   
		{  
		planetRepository.save(planet);  
			} 
		//deleting a specific record  
		public void delete(Planet planet)   
		{  
				planetRepository.delete(planet);  
		}  
	}  

