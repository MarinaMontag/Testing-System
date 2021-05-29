package ua.knu.montag.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Test")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Integer mark;
    @ManyToOne
    @JoinColumn(name = "subject_id",
            foreignKey = @ForeignKey(name = "SUBJECT_ID_FK"))
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "member_id",
            foreignKey = @ForeignKey(name = "MEMBER_ID_FK"))
    private Member member;
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question>questions=new ArrayList<>();
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Result>results=new ArrayList<>();
}
