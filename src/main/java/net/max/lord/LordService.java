package net.max.lord;

import java.util.ArrayList;  
import java.util.List;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;   
@Service  
public class LordService   
{  
@Autowired  
LordRepository lordRepository;  

//getting all student records  
public List<Lord> getAllLord()   
{  
List<Lord> lords = new ArrayList<Lord>();  
lordRepository.findAll().forEach(Lord -> lords.add(Lord));  
return lords;  
}  

public List<Lord> findQuery()   
{  	 
return lordRepository.findQuery();  
} 
//findAllByOrderById
public List<Lord> getByAge()   
{  	 
return lordRepository.findFirst10ByOrderByAge();  
}   
 
public void saveOrUpdate(Lord lord)   
{  
	lordRepository.save(lord);  
}  

public void insert(Lord lord)   
{  
	lordRepository.save(lord);  
} 
//deleting a specific record  
public void delete(int id)   
{  
	lordRepository.deleteById(id);  
}  

	 

}  

