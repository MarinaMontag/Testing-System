package ua.knu.montag.spring.service.implementations;

import org.springframework.stereotype.Service;
import ua.knu.montag.spring.dao.interfaces.SubjectDAO;
import ua.knu.montag.spring.model.Subject;
import ua.knu.montag.spring.model.Test;
import ua.knu.montag.spring.service.interfaces.SubjectService;

import java.util.List;
@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectDAO dao;

    public SubjectServiceImpl(SubjectDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Subject> getSubjects() {
        return dao.getAllSubjects();
    }

    @Override
    public List<Test> getSubjectTests(long id) {
        return dao.getAllSubjectTests(id);
    }
}
