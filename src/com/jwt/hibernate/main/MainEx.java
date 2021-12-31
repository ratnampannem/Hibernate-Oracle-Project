package com.jwt.hibernate.main;

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import com.jwt.hibernate.entity.Employee;
import com.jwt.hibernate.util.HibernateUtil;

public class MainEx {
	
	public static void main(String[] args) {
		MainEx mainEx = new MainEx();
		
		//mainEx.saveEmployee("Mukesh", "CEO", 100000, 893965);
		//mainEx.saveEmployee("Ravi", "Manager", 50000, 996654);
		//mainEx.saveEmployee("Amit", "PM", 45000, 93445);
		mainEx.retriveEmployee(); 
	}
	
	public void saveEmployee(String name, String city, int sal, int phone) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
 
        try {
            transaction = session.beginTransaction();
            Employee employee = new Employee();
            employee.setName(name);
            employee.setSal(sal);
            employee.setCity(city);
            employee.setPhone(phone);
            session.save(employee);
            transaction.commit();
            System.out.println("Records inserted sucessessfully");
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
 
    }
	
	public void retriveEmployee()
	 
    {
 
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List employee = session.createQuery("from Employee").list();
 
            for (Iterator iterator = employee.iterator(); iterator.hasNext();) {
                Employee employee1 = (Employee) iterator.next();
                System.out.println(employee1.getName() + "  "
                        + employee1.getCity() + "  " + employee1.getSal()
                        + "   " + employee1.getPhone());
            }
            transaction.commit();
 
        } catch (HibernateException e) {
 
            transaction.rollback();
 
            e.printStackTrace();
 
        } finally {
 
            session.close();
 
        }
    }
	

}
