package university.department.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import university.department.entity.Department;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Department> getDepartments() {
		//get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//create query ... order by budget
		Query query = session.createQuery("FROM Department ORDER BY budget", Department.class);
		
		//execute query and get result list
		List<Department> departments = query.getResultList();
		//return the result
		return departments;
	}

	@Override
	public void saveDepartment(Department theDepartment) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theDepartment);	
	}

	@Override
	public Department getDepartment(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Department theDepartment = session.get(Department.class, theId);
		return theDepartment;
	}

	@Override
	public void deleteDepartment(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Department theDepartment = session.get(Department.class, theId);
		session.delete(theDepartment);
	}

}
