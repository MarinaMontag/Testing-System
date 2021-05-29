package ua.knu.montag.spring.service.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.knu.montag.spring.dao.interfaces.MemberDAO;
import ua.knu.montag.spring.model.Member;
import ua.knu.montag.spring.model.Result;
import ua.knu.montag.spring.model.Test;
import ua.knu.montag.spring.service.interfaces.MemberService;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberDAO dao;
    public MemberServiceImpl(MemberDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public long save(Member member) {
        return dao.save(member);
    }

    @Override
    @Transactional
    public Member getMemberById(long id) {
        return dao.getById(id);
    }

    @Override
    @Transactional
    public Member getMemberByEmail(String email) {
        return dao.getByEmail(email);
    }

    @Override
    @Transactional
    public Member getMemberByEmailAndPassword(String email, String password) {
        return dao.getByEmailAndPassword(email, password);
    }

    @Override
    @Transactional
    public void update(long id, Member member) {
        dao.update(id, member);
    }

    @Override
    @Transactional
    public void delete(long id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public List<Result> getMemberResults(long id) {
        return dao.getResults(id);
    }

    @Override
    @Transactional
    public List<Test> getTestsCreatedByMember(long id) {
        return dao.getTests(id);
    }
}
