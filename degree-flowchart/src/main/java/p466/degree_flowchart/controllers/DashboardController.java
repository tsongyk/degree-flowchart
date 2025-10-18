package p466.degree_flowchart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import p466.degree_flowchart.data.StudentRepository;
import p466.degree_flowchart.model.Student;
import p466.degree_flowchart.model.Course;
import p466.degree_flowchart.model.Course.Category;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {
        Student student = (Student) session.getAttribute("loggedInStudent");
        if (student == null) {
            return "redirect:/login";
        }
        model.addAttribute("student", student);
        
        // Add Fall semester courses
        List<Course> fallCourses = new ArrayList<>();
        fallCourses.add(new Course("CSCI–C 200", "Introduction to Computers and Programming", Category.CORE, 3, ""));
        fallCourses.add(new Course("CSCI–C 211", "Introduction to Computer Science", Category.CORE, 4, ""));
        fallCourses.add(new Course("MATH–M 211", "Calculus I", Category.MATH, 4, ""));
        fallCourses.add(new Course("ENG–W 170", "Projects in Reading & Writing (Introduction to Argumentative Writing)", Category.HUMANITIES, 3, ""));
        fallCourses.add(new Course("ELECTIVE", "Elective Course", Category.ELECTIVE, 3, ""));
        
        // Add Spring semester courses
        List<Course> springCourses = new ArrayList<>();
        springCourses.add(new Course("CSCI–C 212", "Introduction to Software Systems", Category.CORE, 4, "CSCI–C 211"));
        springCourses.add(new Course("MATH–M 212", "Calculus II", Category.MATH, 4, "MATH–M 211"));
        springCourses.add(new Course("MATH–M 303", "Linear Algebra for Undergraduates", Category.MATH, 3, ""));
        springCourses.add(new Course("IUB GENED", "Breadth of Inquiry: Arts & Humanities", Category.HUMANITIES, 3, ""));
        springCourses.add(new Course("IUB GENED", "Breadth of Inquiry: Social & Historical Studies", Category.HUMANITIES, 3, ""));
        springCourses.add(new Course("ELECTIVE", "Elective Course", Category.ELECTIVE, 3, ""));
        
        model.addAttribute("fallCourses", fallCourses);
        model.addAttribute("springCourses", springCourses);
        
        return "dashboard";
    }
}