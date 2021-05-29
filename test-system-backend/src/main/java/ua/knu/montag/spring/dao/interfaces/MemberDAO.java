package ua.knu.montag.spring.dao.interfaces;

import ua.knu.montag.spring.model.Member;
import ua.knu.montag.spring.model.Result;
import ua.knu.montag.spring.model.Test;

import java.util.List;

public interface MemberDAO {
    long save(Member member);
    Member getById(long id);
    Member getByEmail(String email);
    void update(long id, Member member);
    void delete(long id);
    List<Result> getResults(long id);
    List<Test> getTests(long id);
}
