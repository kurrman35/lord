package net.max.lord;
import java.util.List;

import org.springframework.data.repository.CrudRepository; 
 import net.max.lord.Planet;
 
public interface PlanetRepository extends CrudRepository<Planet, Integer>  
{  
	List<Planet> findByLord_NameLikeIgnoreCase(String planet);
	   List<Planet> findAll();
		
}  