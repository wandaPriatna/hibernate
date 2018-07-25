package org.wanda.hibernate.hibernateTest;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.wanda.hibernate.pojo.Employee;
import org.wanda.hibernate.pojo.HibernateUtil;
import org.wanda.hibernate.pojo.Person;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static void main(String[] args) {
	/*	Employee emp = new Employee();
		emp.setName("wanda");
		emp.setRole("CEO");
		emp.setInsertTime(new Date());
		*/
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
		//session.save(emp);
		//Commit transaction
		
		List<Employee> list = session.createCriteria(Employee.class).list();
		System.out.println(list);
		session.getTransaction().commit();
		//terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();
	}
}
