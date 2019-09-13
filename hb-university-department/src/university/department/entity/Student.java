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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="adress")
	private String adress;
	@Column(name="speciality")
	private String speciality;
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, 
						CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="department_id")
	private Department department;
	@ManyToMany(fetch=FetchType.LAZY, 
			cascade= {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
			name="student_course",
			joinColumns = @JoinColumn(name="student_id"),
			inverseJoinColumns = @JoinColumn(name="course_id")
			)
	
	private List<Course> courses;
	@Transient
	private int temporary;
	
	public Student() {
		
	}

	public Student(String firstName, String lastName, String speciality) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.speciality = speciality;
	}

	public Student(String firstName, String lastName, String adress, String speciality) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.speciality = speciality;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getSpeciality() {
		return speciality;
	}
	

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public int getTemporary() {
		return temporary;
	}

	public void setTemporary(int temporary) {
		this.temporary = temporary;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName +
				", lastName=" + lastName + ", adress=" + adress +
				", speciality=" + speciality + ", department=" + 
				department + ", courses=" + courses + "]";
	}

	public void addCourse(Course tempCourse) {
		if (courses == null) {
			courses = new ArrayList<>();
		}
		courses.add(tempCourse);
	}
	
	
	
	

}
