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
@Table(name="course")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="topic")
	private String topic;
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, 
						CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="teacher_id")
	private Teacher teacher;
	@ManyToMany(fetch=FetchType.LAZY, 
			cascade= {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
			name="student_course",
			joinColumns = @JoinColumn(name="course_id"),
			inverseJoinColumns = @JoinColumn(name="student_id")
			)
	private List<Student> students;
	@Transient
	private int temporary;
	
	public Course() {
		
	}

	public Course(String topic, Teacher teacher) {
		super();
		this.topic = topic;
		this.teacher = teacher;
	}

	public Course(String topic) {
		super();
		this.topic = topic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public int getTemporary() {
		return temporary;
	}

	public void setTemporary(int temporary) {
		this.temporary = temporary;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", topic=" + 
				topic + ", teacher=" + teacher + 
				", students=" + students + "]";
	}

	public void addStudent(Student pmtStudent) {
		if(students == null) {
			students = new ArrayList<>();
		}
		students.add(pmtStudent);
	}

	
}
