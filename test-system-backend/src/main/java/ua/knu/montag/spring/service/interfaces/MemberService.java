package ua.knu.montag.spring.service.interfaces;

import ua.knu.montag.spring.model.Member;
import ua.knu.montag.spring.model.Result;
import ua.knu.montag.spring.model.Test;

import java.util.List;

public interface MemberService {
    long save(Member member);
    Member getMemberById(long id);
    Member getMemberByEmail(String email);
    void update(long id, Member member);
    void delete(long id);
    List<Result> getMemberResults(long id);
    List<Test> getTestsCreatedByMember(long id);
}
