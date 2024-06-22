package com.docker.multicontainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

    @GetMapping
    public String greet(){
        return "Welcome to Docker-MultiContainer Project";
    }

    @Autowired StudRepo studRepo;

    @GetMapping("/getall")
    public List<Student> getStud(){
        return studRepo.findAll();
    }

    @GetMapping("/load")
    public String loadStud(){
        List<Student> stud = Arrays.asList(new Student("naveen", 32),
                new Student("JP", 33),
                new Student("Shravan", 27));
        studRepo.saveAll(stud);
        return "Data Loaded";
    }
}
