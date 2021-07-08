package net.max.lord;
 
  
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

@Entity    
//@Table  (name = "LORD")

public class Lord   
{   
 
	public Lord() {}
	
	public Lord(String i) {
	 	this.name=i;
	}
	
@Id
 @Column  (name="lord_name")
private String name;   

//@Column  
private int age;     
 

@OneToMany(mappedBy = "lord")
private List<Planet> planets;//=new ArrayList<Planet>();

public List<Planet> getPlanetList(){
	return planets;
}

public void setPlanetList( List<Planet> p) {
	this.planets=p;
}


public String getName()   
{  
	 
return name;  
}  
public void setName(String name)   
{  
this.name = name;  
}  
public int getAge()   
{  
return age;  
}  
public void setAge(int age)   
{  
this.age = age;  
}  
    
}  