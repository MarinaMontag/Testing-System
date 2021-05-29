package ua.knu.montag.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Question")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private Integer points;
    @ManyToOne
    @JoinColumn(name = "test_id",
            foreignKey = @ForeignKey(name = "TEST_ID_FK")
    )
    private Test test;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers=new ArrayList<>();

}
