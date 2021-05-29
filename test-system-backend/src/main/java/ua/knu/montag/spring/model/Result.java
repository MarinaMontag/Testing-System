package ua.knu.montag.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Result")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private Integer mark;
    @ManyToOne
    @JoinColumn(name = "member_id",
            foreignKey = @ForeignKey(name = "MEMBER_ID_FK"))
    private Member member;
    @ManyToOne
    @JoinColumn(name = "test_id",
            foreignKey = @ForeignKey(name = "TEST_ID_FK"))
    private Test test;
}
