package university.department.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="budget")
	private int budget;
	@OneToMany(fetch=FetchType.LAZY,
			mappedBy="department",
			cascade=CascadeType.ALL)
	private List<Student> students;
	@OneToMany(fetch=FetchType.LAZY,
			mappedBy="department",
			cascade=CascadeType.ALL)
	private List<Teacher> teachers;
	
	public Department() {
		
	}

	public Department(String name, int budget) {
		super();
		this.name = name;
		this.budget = budget;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	
	public void addStudent(Student pmtStudent) {
		if(students == null) {
			students = new ArrayList<>();
		}
		students.add(pmtStudent);
	}
	
	public void addTeacher(Teacher pmtTeacher) {
		if(teachers == null) {
			teachers = new ArrayList<>();
		}
		teachers.add(pmtTeacher);
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" +
				name + ", budget=" + budget + ", students=" +
				students + ", teachers=" + teachers + "]";
	}
	
	

}
