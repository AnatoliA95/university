package university.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import university.department.dao.CourseDAO;
import university.department.dao.DepartmentDAO;
import university.department.dao.StudentDAO;
import university.department.dao.TeacherDAO;
import university.department.entity.Course;
import university.department.entity.Department;
import university.department.entity.Student;
import university.department.entity.Teacher;
@Service
public class UniversityServiceImpl implements UniversityService{
	@Autowired
	private DepartmentDAO departmentDAO;
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private TeacherDAO teacherDAO;
	@Autowired
	private CourseDAO courseDAO;
	
	
	@Transactional
	public List<Department> getDepartments() {
		return departmentDAO.getDepartments();
	}


	@Transactional
	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}


	@Transactional
	public List<Teacher> getTeachers() {
		return teacherDAO.getTeachers();
	}


	@Transactional
	public List<Course> getCourses() {
		return courseDAO.getCourses();
	}


	@Transactional
	public void saveDepartment(Department theDepartment) {
		departmentDAO.saveDepartment(theDepartment);
	}


	@Transactional
	public void saveStudent(Student theStudent) {
		studentDAO.saveStudent(theStudent);	
	}


	@Transactional
	public void saveTeacher(Teacher theTeacher) {
		teacherDAO.saveTeacher(theTeacher);	
	}


	@Transactional
	public void saveCourse(Course theCourse) {
		courseDAO.saveCourse(theCourse);
	}


	@Transactional
	public Department getDepartment(int theId) {
		return departmentDAO.getDepartment(theId);
	}


	@Transactional
	public Student getStudent(int theId) {
		return studentDAO.getStudent(theId);
	}


	@Transactional
	public Teacher getTeacher(int theId) {
		return teacherDAO.getTeacher(theId);
	}


	@Transactional
	public Course getCourse(int theId) {
		return courseDAO.getCourse(theId);
	}


	@Transactional
	public void deleteDepartment(int theId) {
		departmentDAO.deleteDepartment(theId);		
	}


	@Transactional
	public void deleteStudent(int theId) {
		studentDAO.deleteStudent(theId);
	}


	@Transactional
	public void deleteTeacher(int theId) {
		teacherDAO.deleteTeacher(theId);
	}


	@Transactional
	public void deleteCourse(int theId) {
		courseDAO.deleteCourse(theId);
	}
	

}
