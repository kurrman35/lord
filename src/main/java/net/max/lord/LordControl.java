package net.max.lord;


import java.util.List;
import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
 



@Controller
public class  LordControl {

@Autowired  
LordService lordService;  


//	@GetMapping
@RequestMapping(value="/lord", method=RequestMethod.GET)

	public String main(Model model) {
	 	List<Lord> list=	lordService.getAllLord();				
		model.addAttribute ("list", list);
	 	model.addAttribute ("lord", new Lord());		
		return "lord";
	}	 
	   
	   @RequestMapping(value="/lord", method=RequestMethod.POST)
	   public String greetingSubmit( Lord lord , Model model) {
	 	if(lord!=null&&lord.getName()!=""&&lord.getAge()!=0) {
		    lordService.saveOrUpdate(lord); }
	 	Iterable<Lord> list=	lordService.getAllLord();			
	     model.addAttribute("lord",lord);		 
	   model.addAttribute ("list", list);		
		 	 		  
	         return "lord";
	    }
	   
	   @RequestMapping(value="/top", method=RequestMethod.GET)
	    public String getTop( Model model) {
		   System.out.println("topp" );
	 	 	
		 	Iterable<Lord>  list=	lordService.getByAge();
	 	 	 	   		   model.addAttribute ("list",  list);	
		 	 	    	model.addAttribute ("str", "TOPLORD");
				 	  	 	  	
	         return "top";
	    }
	   
	   @RequestMapping(value="/lazy", method=RequestMethod.GET)
	    public String getLazy( Model model) {
		   System.out.println("lazy" );
		 		Iterable<Lord>   list=	lordService.findQuery();			
	 	 	 	   		   model.addAttribute ("list",  list);	
		 	 	 	  	model.addAttribute ("str", "LAZYLORD");		 	 	  	
	         return "top";
	    }
	   
	
}