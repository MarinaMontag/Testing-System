package ua.knu.montag.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="Answer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private Boolean correctness;
    @ManyToOne
    @JoinColumn(name = "question_id",
            foreignKey = @ForeignKey(name = "QUESTION_ID_FK"))
    private Question question;
}
