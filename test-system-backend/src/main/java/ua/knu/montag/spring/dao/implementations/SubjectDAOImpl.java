package ua.knu.montag.spring.dao.implementations;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.knu.montag.spring.dao.interfaces.SubjectDAO;
import ua.knu.montag.spring.model.Subject;
import ua.knu.montag.spring.model.Test;

import java.util.List;
@Repository
public class SubjectDAOImpl implements SubjectDAO {
    private SessionFactory sessionFactory;

    public SubjectDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Subject> getAllSubjects() {
        List<Subject>list = sessionFactory.getCurrentSession().createQuery("from Subject ").list();
        return list;
    }


    @Override
    public List<Test> getAllSubjectTests(long id) {
        return getSubjectById(id).getTests();
    }

    @Override
    public Subject getSubjectById(long id) {
        return sessionFactory.getCurrentSession().get(Subject.class, id);
    }
}
