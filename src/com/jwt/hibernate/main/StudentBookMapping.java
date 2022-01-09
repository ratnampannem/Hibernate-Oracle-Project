package com.jwt.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jwt.hibernate.entity.Bank;
import com.jwt.hibernate.entity.Book;
import com.jwt.hibernate.entity.Customer;
import com.jwt.hibernate.entity.Student;
import com.jwt.hibernate.util.HibernateUtil;

public class StudentBookMapping {
	
	public static void main(String[] args) {
		
		StudentBookMapping std_book = new StudentBookMapping();
		std_book.retriveData();
		
		/**SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student1 = new Student();
		student1.setStudentName("Mahi");
		student1.setBranch("CSE");
		
		Student student2 = new Student();
		student2.setStudentName("Kalyan");
		student2.setBranch("Mech");
		
		Set<Student> studentList = new HashSet<Student>();
		studentList.add(student1);
		studentList.add(student2);
		
		Book book1 = new Book();
		book1.setBookName("Java");
		book1.setAuthor("James Gosling");
		
		Book book2 = new Book();
		book2.setBookName("Theory of Machines");
		book2.setAuthor("R S Khurmi & J K Gupta");
		
		Book book3 = new Book();
		book3.setBookName("Mathematics");
		book3.setAuthor("T K V Iyengar");
		
		Book book4 = new Book();
		book4.setBookName("Drawing");
		book4.setAuthor("Thomas Ewing French");
		
		Set<Book> bookList1 = new HashSet<Book>();
		bookList1.add(book1);
		bookList1.add(book3);
		bookList1.add(book4);
        student1.setBooks(bookList1);
		
        Set<Book> bookList2 = new HashSet<Book>();
		bookList2.add(book2);
		bookList2.add(book3);
		bookList1.add(book4);
        student2.setBooks(bookList2);
        
        session.save(student1);
        session.save(student2);
		
        transaction.commit();
        session.close();
        System.out.println("successfully persisted Student and Books details");*/
        
	}
	
	public void retriveData() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
				transaction = session.beginTransaction();
				String querySting = "from Student where student_Id = :fffffff";
				Query query = session.createQuery(querySting);
				query.setInteger("fffffff", 1);
	        	Student student = (Student) query.uniqueResult();
	        	System.out.println(student.getStudentId() + " " +student.getStudentName());
	        	Set<Book> booksSet = student.getBooks();
	        	for (Book book : booksSet) {
					System.out.println(book.getBookName());
				}
		}catch (HibernateException e) {
			
			e.printStackTrace();
		}
   }
	
	
}
