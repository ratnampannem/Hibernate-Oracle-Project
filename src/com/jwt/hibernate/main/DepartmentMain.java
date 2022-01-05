package com.jwt.hibernate.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jwt.hibernate.entity.Department;
import com.jwt.hibernate.util.HibernateUtil;

public class DepartmentMain {
	public static void main(String[] args) {
		
		DepartmentMain deptMain = new DepartmentMain();
		/**deptMain.saveDepartment("Jai", 48);
		deptMain.saveDepartment("Megha", 64);
		deptMain.saveDepartment("Sasi", 21);*/
		
		deptMain.deleteDepartment();
		//deptMain.retriveDepartment();
		//deptMain.updateDepartment();
	}
	
	private void updateDepartment() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String queryString = "from Department where strength= :strength";
			Query query = session.createQuery(queryString);
			query.setInteger("strength", 63);
			//Department department = (Department) query.uniqueResult();
			//session.update(department);
			List<Department> deptList = (List<Department>) query.list();
			for(Department dept : deptList) {
				dept.setStrength(15);
				session.update(dept);
			}
			transaction.commit();
			System.out.println("Record updated successfully...");
		}catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

	private void deleteDepartment() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String queryString = "from Department where name = :name";
			Query query = session.createQuery(queryString);
			query.setString("name","Sasi" );
			Department department = (Department) query.uniqueResult();
			session.delete(department);
			transaction.commit();
			System.out.println("Record deleted successfully...");
		}catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

	public void saveDepartment(String name, int strength) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			Department department = new Department();
			department.setName(name);
			department.setStrength(strength);
			session.save(department);
			transaction.commit();
			System.out.println(" Record inserted successfully......");
		}catch(HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public void retriveDepartment() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//Transaction transaction = null;
		
		try {
			
			//transaction = session.beginTransaction();
			/**List<Department> deptList = session.createQuery("from Department").list();
			for(Department dept : deptList) {
				System.out.println(dept.getDeptId() + " " + dept.getName() + " " + dept.getStrength());
			}*/
			
			SQLQuery query = session.createSQLQuery("select deptId, name from DEPTCRUD");
			List<Object[]> rows = query.list();
			List<Department> dList = new ArrayList<Department>();
			for(Object[] row : rows){
				Department d = new Department();
				d.setDeptId(Integer.parseInt(row[0].toString()));
				d.setName(row[1].toString());
				dList.add(d);
			}

			
		}catch (HibernateException e) {
			//transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
}
