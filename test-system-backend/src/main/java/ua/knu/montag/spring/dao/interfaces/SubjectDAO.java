package ua.knu.montag.spring.dao.interfaces;

import ua.knu.montag.spring.model.Subject;
import ua.knu.montag.spring.model.Test;

import java.util.List;

public interface SubjectDAO {
    List<Subject> getAllSubjects();
    List<Test> getAllSubjectTests(long id);
    Subject getSubjectById(long id);
}
