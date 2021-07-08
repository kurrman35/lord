package net.max.lord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
 @SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		 System.out.println("  offset " );
			
	 SpringApplication.run(DemoApplication.class, args);
		//  ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("appContext.xml");
		//  TestBean g= context.getBean("testBean",TestBean.class);
	 //	 System.out.println("  offset "+ g.getContent() );
	 	// context.close();
			
	}

}
