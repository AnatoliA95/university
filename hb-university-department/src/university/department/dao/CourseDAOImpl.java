package university.department.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import university.department.entity.Course;
import university.department.entity.Teacher;

@Repository
public class CourseDAOImpl implements CourseDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Course> getCourses() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Course ORDER BY teacher_id");
		List<Course> courses = query.getResultList();
		return courses;
	}

	@Override
	public void saveCourse(Course theCourse) {
		Session session = sessionFactory.getCurrentSession();
		int teacherId = theCourse.getTemporary();
		Teacher tempTeacher = session.get(Teacher.class, teacherId);
		tempTeacher.addCourse(theCourse);
		theCourse.setTeacher(tempTeacher);
		session.saveOrUpdate(theCourse);
	}

	@Override
	public Course getCourse(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Course theCourse = session.get(Course.class, theId);
		return theCourse;
	}

	@Override
	public void deleteCourse(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Course theCourse = session.get(Course.class, theId);
		session.delete(theCourse);
	}

}
