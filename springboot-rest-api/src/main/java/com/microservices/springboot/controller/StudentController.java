package com.microservices.springboot.controller;

import com.microservices.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,"Tejas","Bansal");
//        return new ResponseEntity<>(student,HttpStatus.OK);
        return ResponseEntity.ok().header("custom-headers","tejas test").body(student);
    }


    @GetMapping
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Tejas","Bansal"));
        students.add(new Student(2, "Ravi","Kumar"));
        students.add(new Student(3,"Saurabh","Dangwal"));
        students.add(new Student(4,"Kamlakar","Tiwari"));

        return students;
    }

    @GetMapping("{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int id,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName
                                        ){
        return new Student(id,firstName,lastName);
    }

    // Spring boor REST API with Request Params
    // http://locahost:8080/students/query?id=1&firstName=Tejas
    @GetMapping("query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName
                                            ){
        return new Student(id,firstName,"Bansal");
    }

    // Rest API that handles HTTP Post request  - create new user

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // Rest API that handles HTTP Post request  - create new user

    @PutMapping("{id}/update")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @DeleteMapping("{id}/delete")
    public String deleteStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "Student successfully deleted";
    }
}
