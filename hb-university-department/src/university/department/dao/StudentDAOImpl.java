package university.department.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import university.department.entity.Department;
import university.department.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Student> getStudents() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Student ORDER BY department_id");
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	public void saveStudent(Student theStudent) {
		Session session = sessionFactory.getCurrentSession();
		int DepartmentId = theStudent.getTemporary();
		Department tempDepartment = session.get(Department.class, DepartmentId);
		tempDepartment.addStudent(theStudent);
		theStudent.setDepartment(tempDepartment);
		session.saveOrUpdate(theStudent);		
	}

	@Override
	public Student getStudent(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Student theStudent = session.get(Student.class, theId);
		return theStudent;
	}

	@Override
	public void deleteStudent(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Student theStudent = session.get(Student.class, theId);
		session.delete(theStudent);
	}
	

}
