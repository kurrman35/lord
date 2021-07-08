package net.max.lord;
import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository; 
import net.max.lord.Lord;

 
public interface LordRepository extends CrudRepository<Lord, Integer>  
	{

	 
	List<Lord> findFirst10ByOrderByAge();
	
	   List<Lord> findAll();
	 
  	 
	    @Query(value ="select l from  Lord  l  where l.name  not in"
		   		+ "(SELECT l.name FROM Lord l JOIN  Planet  p ON l.name=p.lord.name)")
	   List<Lord> findQuery();
	}
   