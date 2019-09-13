package university.department.service;

import java.util.List;

import university.department.entity.Course;
import university.department.entity.Department;
import university.department.entity.Student;
import university.department.entity.Teacher;

public interface UniversityService {
	public List<Department> getDepartments();

	public List<Student> getStudents();

	public List<Teacher> getTeachers();

	public List<Course> getCourses();

	public void saveDepartment(Department theDepartment);

	public void saveStudent(Student theStudent);

	public void saveTeacher(Teacher theTeacher);

	public void saveCourse(Course theCourse);

	public Department getDepartment(int theId);

	public Student getStudent(int theId);

	public Teacher getTeacher(int theId);

	public Course getCourse(int theId);

	public void deleteDepartment(int theId);

	public void deleteStudent(int theId);

	public void deleteTeacher(int theId);

	public void deleteCourse(int theId);
}
