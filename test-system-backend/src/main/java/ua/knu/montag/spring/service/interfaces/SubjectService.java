package ua.knu.montag.spring.service.interfaces;

import ua.knu.montag.spring.model.Subject;
import ua.knu.montag.spring.model.Test;

import java.util.List;

public interface SubjectService {
    List<Subject> getSubjects();
    List<Test> getSubjectTests(long id);

}
