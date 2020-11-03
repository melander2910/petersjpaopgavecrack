package com.jpaopgave.peter.controller;

import com.jpaopgave.peter.model.Course;
import com.jpaopgave.peter.model.Student;
import com.jpaopgave.peter.model.StudentPsychologist;
import com.jpaopgave.peter.service.CourseService;
import com.jpaopgave.peter.service.StudentPsychologistService;
import com.jpaopgave.peter.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @Autowired
    StudentPsychologistService studentPsychologistService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/showstudents")
    public String showstudents(Model model) {
        List<Student> studentList = studentService.fetchAll();
        model.addAttribute("students", studentList);

        List<StudentPsychologist> studentPsychologistList = studentPsychologistService.fetchAll();
        model.addAttribute("psychologists", studentPsychologistList);

        List<Course> courseList = courseService.fetchAll();
        model.addAttribute("courses", courseList);
        return "showstudents";
    }

    @PostMapping("/showstudents")
    public String studentPsychologist(@ModelAttribute StudentPsychologist studentPsychologistList, Model model) {
        studentPsychologistService.create(studentPsychologistList);
            return "redirect:/showstudents";

    }

    @PostMapping("/createstudent")
    public String student(@ModelAttribute Student studentList, Model model) {
        studentService.create(studentList);
        return "redirect:/showstudents";

    }

}
