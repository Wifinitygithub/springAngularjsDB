package com.xvitcoder.angualrspringapp.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xvitcoder.angualrspringapp.beans.Train;
import com.xvitcoder.angualrspringapp.dao.ContactDAO;
 
 
public class App {
	public static void main(String[] args) {
	    
            ApplicationContext context = new AnnotationConfigApplicationContext(MvcConfiguration.class);
            ContactDAO obj = (ContactDAO) context.getBean("helloBean");
            Train contact  = new Train();
            contact.setId((long) 2);
            contact.setName("udayy");
            contact.setSpeed(2456);
            contact.setDiesel(true);
            
            
            obj.saveOrUpdate(contact);
	    //obj.list();
	}
}