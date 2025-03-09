package com.example.Course.Registration.System.Controller;


import com.example.Course.Registration.System.Model.Course;
import com.example.Course.Registration.System.Model.CourseRegistry;
import com.example.Course.Registration.System.Service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5500")

public class CourseController {

    @Autowired
    courseService courseservice;

    @GetMapping("/courses")
    public List<Course> availableCourses(){
        return courseservice.availableCourses();
    }

    @PostMapping("/courses/register")
    public String enrollCourse(@RequestParam("name") String name,
                               @RequestParam("emailId") String emailId,
                               @RequestParam("courseName") String courseName){
        courseservice.enrollCourse(name,emailId,courseName);
        return "Congratulations !"+ name + " Enrollment Successful for " +courseName;
    }

}
