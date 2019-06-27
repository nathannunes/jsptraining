package com.nseit.ManytoMany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;



public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Hibernate many to many (Annotation)");
    	
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
    	
    	Stock stock = new Stock();
    	stock.setStockId(101);
    	stock.setStockCode("MSFT");
    	stock.setStockName("Microsoft");
    	
    	Category category1 = new Category("CONSUMER","CONSUMER COMPANY", 1001);
    	Category category2 = new Category("INVESTER","INVESTER COMPANY", 1002);
    	
    	Set<Category>  categories = new HashSet<Category>();
    	categories.add(category1);
    	categories.add(category2);
    	
    	stock.setCategories(categories);
    	session.save(stock);
    	session.getTransaction().commit();
		System.out.println("Done");

    	
    }
}
