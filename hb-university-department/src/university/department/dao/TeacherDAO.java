package university.department.dao;

import java.util.List;

import university.department.entity.Teacher;

public interface TeacherDAO {
	public List<Teacher> getTeachers();

	public void saveTeacher(Teacher theTeacher);

	public Teacher getTeacher(int theId);

	public void deleteTeacher(int theId);
}
