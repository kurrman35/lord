package net.max.lord;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RequestBody;
 

@Controller
public class  PlanetControl {

@Autowired  
PlanetService planetService; 
@Autowired
LordService  lordService;

	 	  

	   @RequestMapping(value="/planet", method=RequestMethod.GET)
	    public  String addForm(Model model) {
		   Lord lord =new Lord("");
		   lordService.saveOrUpdate(lord);
		     List<Lord> lordList= lordService.getAllLord();
		   System.out.println("ArrayListSize  ===  "+lordList.size());
		   List<Planet> planetList=	planetService.getAllPlanet();
			   System.out.println("ArrayPlanetListSize  === "+planetList.size());
				
	 		   model.addAttribute ("planetList", planetList);		
	 	    model.addAttribute ("lordList", lordList);		 			
	      model.addAttribute("planet", new Planet( ));
	   //   System.out.println(  " lord   == "  +planet.getLord() );
		
	        return "planet";
	    }
	   
	  // может прийти объект если его нет в сеансе 
	   @RequestMapping(value="/planet", method=RequestMethod.POST)
	    public String  Submit(@ModelAttribute Planet planet , Model model) {
	
		   System.out.println("Submit planet  ===  "+ planet.getName());
			
		 	  	if(planet!=null&&planet.getName()!=""){//&&planet.getLord().getName()!="") {
		 			 		planetService.saveOrUpdate(planet); }		 	    		 
	 		Iterable<Planet> planetList=	planetService.getAllPlanet();			
	 		   model.addAttribute ("planetList", planetList);		
	 		     List<Lord> lordList= lordService.getAllLord();	 			
	 		   model.addAttribute ("lordList", lordList);	 			  
		   model.addAttribute("planet", planet);
		 		 	
	        return "planet";
	    }
	   
	   @RequestMapping(value="/delete", method=RequestMethod.GET)
	    public  String Del( Model model	) {
	        Iterable<Planet> planetList=	planetService.getAllPlanet();			
				     //  Iterable<Planet> planetList=	planetService.findByName("Курман");			
		   model.addAttribute ("planetList", planetList);	
		   model.addAttribute("planet", new Planet());	 	       
		   
		 	   return "delete";
		    }
	   
	
	 
	   
	   @RequestMapping(value="/delete", method=RequestMethod.POST)
	    public String  DelPlanete(@ModelAttribute Planet planet , Model model) {
		 
	 		planetService.saveOrUpdate(planet);//
			
		  planetService.delete(planet);
		  Iterable<Planet> planetList=	planetService.getAllPlanet();			
		  model.addAttribute ("planetList", planetList);	 	 	  
	
	 	   model.addAttribute("planet", planet);
	        return "delete";
	    }
	   
	   
	   @RequestMapping(value="/gr", method=RequestMethod.POST)
	  	    public @ResponseBody  Planet  GrPlanete2(@RequestBody  Planet planet){	 	
	 	  
	 	   System.out.println("GrPlanete2 planet  ===  ");
	           return  planet;
	     }   
		   
	   
	  
}