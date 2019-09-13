package university.department.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import university.department.entity.Department;
import university.department.entity.Teacher;
@Repository
public class TeacherDAOImpl implements TeacherDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Teacher> getTeachers() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Teacher ORDER BY department_id");
		List<Teacher> teachers = query.getResultList();
		return teachers;
	}

	@Override
	public void saveTeacher(Teacher theTeacher) {
		Session session = sessionFactory.getCurrentSession();
		int departmentId = theTeacher.getTemporary();
		Department tempDepartment = session.get(Department.class, departmentId);
		tempDepartment.addTeacher(theTeacher);
		theTeacher.setDepartment(tempDepartment);
		session.saveOrUpdate(theTeacher);
		
	}

	@Override
	public Teacher getTeacher(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Teacher theTeacher = session.get(Teacher.class, theId);
		return theTeacher;
	}

	@Override
	public void deleteTeacher(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Teacher theTeacher = session.get(Teacher.class, theId);
		session.delete(theTeacher);
	}
	
	
}
