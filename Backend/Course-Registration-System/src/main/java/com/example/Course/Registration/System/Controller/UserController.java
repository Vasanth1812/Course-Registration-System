package com.example.Course.Registration.System.Controller;

import com.example.Course.Registration.System.Model.CourseRegistry;
import com.example.Course.Registration.System.Model.Users;
import com.example.Course.Registration.System.Service.UserService;
import com.example.Course.Registration.System.Service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:5500")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    courseService courseservice;

    @PostMapping("/admin/add-user")
    public void adduser(@RequestBody Users user){
        userService.addUser(user);
    }

    @GetMapping("/admin/courses-enrolled")
    public List<CourseRegistry> enrolledStudents(){
        return courseservice.enrolledStudents();
    }

    @DeleteMapping("/admin/courses/{id}")
    public String deleteById(@PathVariable Long id){
        courseservice.deleteById(id);
        return "delete success";
    }
}
