package com.jwt.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jwt.hibernate.entity.Bank;
import com.jwt.hibernate.entity.Customer;
import com.jwt.hibernate.util.HibernateUtil;

public class ManyToManyExample {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Bank bank1 = new Bank();
        bank1.setName("HDFC 12");
        bank1.setName("Bangalore 4444");
        bank1.setIfscCode("HDFCINBBCOC");
       
        Bank bank2 = new Bank();
        bank2.setName("Bank Of America 12");
        bank2.setName("California 5555");
        bank2.setIfscCode("BOFAUS3N");
        
        Set<Bank> banks = new HashSet<Bank>();
        banks.add(bank1);
        banks.add(bank2);
        
        Customer customer1 = new Customer();
        customer1.setEmail("john@gmail.com");
        customer1.setCustomerName("John");
        customer1.setPhoneNumber(1234);
       
        Customer customer2 = new Customer();
        customer2.setEmail("Peter@gmail.com");
        customer2.setCustomerName("Peter");
        customer2.setPhoneNumber(4565);
       
        Customer customer3 = new Customer();
        customer3.setEmail("James@gmail.com");
        customer3.setCustomerName("James");
        customer3.setPhoneNumber(6788);
       
        Customer customer4 = new Customer();
        customer4.setEmail("Raj@gmail.com");
        customer4.setCustomerName("Raj");
        customer4.setPhoneNumber(8909);
        
        Set<Customer> customerList1 = new HashSet<Customer>();
        customerList1.add(customer1);
        customerList1.add(customer2);
        bank1.setCustomers(customerList1);
        
        Set<Customer> customerList2 = new HashSet<Customer>();
        //customerList2.add(customer2);
        customerList2.add(customer3);
        customerList2.add(customer4);
        bank2.setCustomers(customerList2);
        
        session.save(bank1);
        session.save(bank2);
		
        transaction.commit();
        session.close();
        System.out.println("successfully persisted Bank and Customer details");
	}
}
