package ua.knu.montag.spring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.knu.montag.spring.controllers.jwt.JWTConverter;
import ua.knu.montag.spring.model.Member;
import ua.knu.montag.spring.service.interfaces.MemberService;

import static ua.knu.montag.spring.controllers.jwt.SecurityConstants.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class AuthorizationController {
    private final MemberService service;

    public AuthorizationController(MemberService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registration(@RequestBody Member member){
        Member registered = this.service.getMemberByEmail(member.getEmail());
        if(registered==null){
            long id = this.service.save(member);
            String token = JWTConverter.createJWT(member.getEmail(), member.getRole());
            return ResponseEntity.ok().header(HEADER, token).body("New book user registered with id: "+id);
        }
        else return ResponseEntity.badRequest().body("You are already register by this email");
    }
}
