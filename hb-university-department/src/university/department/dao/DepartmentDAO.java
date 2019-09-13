package university.department.dao;

import java.util.List;

import university.department.entity.Department;

public interface DepartmentDAO {
public List<Department> getDepartments();

public void saveDepartment(Department theDepartment);

public Department getDepartment(int theId);

public void deleteDepartment(int theId);
}
