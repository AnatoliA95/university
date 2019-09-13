package university.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import university.department.entity.Course;
import university.department.entity.Department;
import university.department.entity.Student;
import university.department.entity.Teacher;
import university.department.service.UniversityService;

@Controller
@RequestMapping("/university")
public class UniversityController {
	@Autowired 
	UniversityService universityService;

	@RequestMapping("/department") 
	public String createDepartment(Model theModel) {
		List<Department> theDepartments = universityService.getDepartments();
		theModel.addAttribute("departments", theDepartments);
		List<Student> theStudents = universityService.getStudents();
		theModel.addAttribute("students", theStudents);
		List<Teacher> theTeachers = universityService.getTeachers();
		theModel.addAttribute("teachers", theTeachers);
		List<Course> theCourses = universityService.getCourses();
		theModel.addAttribute("courses", theCourses);
		return "list-department";
	}
	
	@GetMapping("/showFormForAddDepartment")
	public String showForm(Model theModel) {
		Department theDepartment = new Department();
		theModel.addAttribute("department", theDepartment);
		return "department-form";
	}
	
	@PostMapping("/saveDepartment")
	public String saveDepartment(@ModelAttribute Department theDepartment) {
	universityService.saveDepartment(theDepartment);
	return "redirect:/university/department";
	}
	
	@GetMapping("/showFormForUpdateDepartment") 
	public String updateDepartment(@RequestParam("departmentId") int theId,
					Model theModel) {
		Department theDepartment = universityService.getDepartment(theId);
		theModel.addAttribute("department", theDepartment);
		return "department-form";
	}
	
	@GetMapping("/deleteDepartment")
	public String deleteDepartment(@RequestParam("departmentId") int theId) {
		universityService.deleteDepartment(theId);
		return "redirect:/university/department";
	}
	
	@GetMapping("/showFormForAddStudent")
	public String showFormForStudent(Model theModel) {
		Student theStudent = new Student();
		List<Department> theDepartments = universityService.getDepartments();
		theModel.addAttribute("departments", theDepartments);
		theModel.addAttribute("student", theStudent);
		return "student-form";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute Student theStudent) {
		universityService.saveStudent(theStudent);
		return "redirect:/university/department";
	}
	
	@GetMapping("/showFormForUpdateStudent") 
	public String updateStudent(@RequestParam("studentId") int theId,
						Model theModel) {
		Student theStudent = universityService.getStudent(theId);
		theModel.addAttribute("student", theStudent);
		List<Department> theDepartments = universityService.getDepartments();
		theModel.addAttribute("departments", theDepartments);
		return "student-form";
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("studentId") int theId) {
		universityService.deleteStudent(theId);
		return "redirect:/university/department";
	}
	
	@GetMapping("/showFormForAddTeacher")
	public String showFormForTeacher(Model theModel) {
		Teacher theTeacher = new Teacher();
		List<Department> theDepartments = universityService.getDepartments();
		theModel.addAttribute("departments", theDepartments);
		theModel.addAttribute("teacher", theTeacher);
		return "teacher-form";
	}
	
	@PostMapping("/saveTeacher")
	public String saveTeacher(@ModelAttribute Teacher theTeacher) {
		universityService.saveTeacher(theTeacher);
		return "redirect:/university/department";
	}
	
	@GetMapping("/showFormForUpdateTeacher")
	public String updateTeacher(@RequestParam("teacherId") int theId,
						Model theModel) {
		Teacher theTeacher = universityService.getTeacher(theId);
		theModel.addAttribute("teacher", theTeacher);
		List<Department> theDepartments = universityService.getDepartments();
		theModel.addAttribute("departments", theDepartments);
		return "teacher-form";
	}
	
	@GetMapping("/deleteTeacher")
	public String deleteTeacher(@RequestParam("teacherId") int theId) {
		universityService.deleteTeacher(theId);
		return "redirect:/university/department";
		}
	
	@GetMapping("/showFormForAddCourse")
	public String showFormForCourse(Model theModel) {
		Course theCourse = new Course();
		List<Teacher> theTeachers = universityService.getTeachers();
		theModel.addAttribute("teachers", theTeachers);
		theModel.addAttribute("course", theCourse);
		return "course-form";
	}
	
	@PostMapping("/saveCourse")
	public String saveCourse(@ModelAttribute Course theCourse) {
		universityService.saveCourse(theCourse);
		return "redirect:/university/department";
	}
	
	@GetMapping("/showFormForUpdateCourse")
	public String updateCourse(@RequestParam("courseId") int theId,
						Model theModel) {
		Course theCourse = universityService.getCourse(theId);
		theModel.addAttribute("course", theCourse);
		List<Teacher> theTeachers = universityService.getTeachers();
		theModel.addAttribute("teachers", theTeachers);
		return "course-form";
	}
	
	@GetMapping("/deleteCourse")
	public String deleteCourse(@RequestParam("courseId") int theId) {
		universityService.deleteCourse(theId);
		return "redirect:/university/department";
	}
}
