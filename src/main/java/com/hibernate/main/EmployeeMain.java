package com.hibernate.main;

import com.hibernate.config.HibernateUtil;
import com.hibernate.entities.Address;
import com.hibernate.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


//select,update,insert,delete
//get,update,save,delete
//SaveOrUpdate,load
//get vs load -> get returns null -> if entity with the id ur looking is not here
//            -> load -> ObjectNotFoundException if entity with that id is not there
//            -> load -> proxy object(temporary fake object(id set))
//select all records from Emploee -> HQL
//HQL(Hibernate Query Language) -> refers to ur class names and property names
public class EmployeeMain {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = new Employee("a","b","c");
        Address address = new Address();
        address.setCity("Jersey City");
        employee.setAddress(address);
        address.setEmployee(employee);
        //== save operation
        //session.save(employee);
        //session.save(address);
        //== get from database
        //Employee emp = session.get(Employee.class, 1L);
        //== load employee from database
        //Employee emp = session.load(Employee.class, 2L);
        //System.out.println(emp.getfName());
        //emp.setfName("x1");
        //session.update(emp);//== update employee
        //session.delete(emp);//== delete employee

        //Select all Employee -> HQL
        String sqlQuery = "FROM Employee";//== Employee is class name not table name
        List<Employee> empList = session.createQuery(sqlQuery).getResultList();
        empList.forEach(a -> System.out.println(a.getfName()));
        transaction.commit();
        session.close();
        sessionFactory.close();

    }

}
