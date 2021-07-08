package net.max.lord;
 

import java.util.concurrent.atomic.AtomicLong;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	 
  
   
	@PostMapping(value="/gr3")  //  /gr рабочий вариант
	   public Planet  Submit(@RequestBody  Planet planet  ) {
			
		
		return   planet;
		 	}
	
 	 
	


}


