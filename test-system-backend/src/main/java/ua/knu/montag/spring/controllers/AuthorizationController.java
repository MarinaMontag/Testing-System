package ua.knu.montag.spring.controllers;

import org.springframework.web.bind.annotation.*;
import ua.knu.montag.spring.controllers.jwt.JWTConverter;
import ua.knu.montag.spring.model.Member;
import ua.knu.montag.spring.service.interfaces.MemberService;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class AuthorizationController {
    private final MemberService service;

    public AuthorizationController(MemberService service) {
        this.service = service;
    }

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public Member registration(@RequestBody Member member){
        Member registered = this.service.getMemberByEmail(member.getEmail());
        if(registered==null){
           long id = this.service.save(member);
            String token = JWTConverter.createJWT(member.getEmail(), member.getRole());
            member.setId(id);
            member.setToken(token);
            return member;
        }
        else return null;
    }
}
