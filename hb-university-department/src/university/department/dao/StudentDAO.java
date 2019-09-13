package university.department.dao;

import java.util.List;

import university.department.entity.Student;

public interface StudentDAO {
	public List<Student> getStudents();

	public void saveStudent(Student theStudent);

	public Student getStudent(int theId);

	public void deleteStudent(int theId);
}
