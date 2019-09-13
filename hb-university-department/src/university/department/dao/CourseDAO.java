package university.department.dao;

import java.util.List;

import university.department.entity.Course;

public interface CourseDAO {
	public List<Course> getCourses();

	public void saveCourse(Course theCourse);

	public Course getCourse(int theId);

	public void deleteCourse(int theId);


}
