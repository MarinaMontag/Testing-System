package ua.knu.montag.spring.dao.implementations;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ua.knu.montag.spring.dao.interfaces.MemberDAO;
import ua.knu.montag.spring.model.Member;
import ua.knu.montag.spring.model.Result;
import ua.knu.montag.spring.model.Test;

import java.util.List;
@Repository
public class MemberDAOImpl implements MemberDAO {
    private final SessionFactory sessionFactory;

    public MemberDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public long save(Member member) {
        sessionFactory.getCurrentSession().save(member);
        return member.getId();
    }

    @Override
    public Member getById(long id) {
        return sessionFactory.getCurrentSession().get(Member.class, id);
    }

    @Override
    public Member getByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        return session.byNaturalId(Member.class)
                .using("email", email)
                .load();
    }

    @Override
    public Member getByEmailAndPassword(String email, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select m from Member m where m.email like :email " +
                "and m.password like :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        return (Member)query.uniqueResult();
    }

    @Override
    public void update(long id, Member member) {
        Session session = sessionFactory.getCurrentSession();
        Member oldMember = session.byId(Member.class).load(id);
        oldMember.setEmail(member.getEmail());
        oldMember.setName(member.getName());
        oldMember.setSurname(member.getSurname());
        oldMember.setPassword(member.getPassword());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Member member = session.byId(Member.class).load(id);
        session.delete(member);
    }

    @Override
    public List<Result> getResults(long id) {
        return getById(id).getResults();
    }

    @Override
    public List<Test> getTests(long id) {
        return getById(id).getTests();
    }
}
