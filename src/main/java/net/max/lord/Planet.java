package net.max.lord;
 
  
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;  
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.*;

@Entity    
///@Table   (name = "PLANET")

public class Planet   
{   
	
	public Planet() {
	  
	}
	
	 
	
	public Planet(  String name,Lord lord) {
		 	this.name=name;
		this.lord=lord;
	}

@Id   
//@GeneratedValue(strategy = GenerationType.IDENTITY)
// private Long id;
//@Column  
private String name;   
 
  @ManyToOne 
  @JoinColumn(name = "lord_name")
private Lord lord;   
 
 
public String getName()   
{  
return name;  
}  
public void setName(String name)   
{  
this.name = name;  
}  
 

public Lord getLord()   
{  
return lord;  
}  
public void setLord(Lord lord)   
{  
this.lord = lord;  
}

    
}  