package ua.knu.montag.spring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.knu.montag.spring.model.Subject;
import ua.knu.montag.spring.model.Test;
import ua.knu.montag.spring.service.interfaces.SubjectService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/subjects")
public class SubjectsController {
    private SubjectService service;

    public SubjectsController(SubjectService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Subject>> getSubjects(){
        return ResponseEntity.ok().body(service.getSubjects());
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Test>> getTests(@PathVariable long id){
        return ResponseEntity.ok().body(service.getSubjectTests(id));
    }
}
