package com.robinfood.polls.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;

    @ManyToOne
    @JoinColumn(name = "id_question_type")
    private QuestionType type;

    @ManyToOne
    @JoinColumn(name = "id_poll")
    private Poll poll;

    @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST)
    private List<Answer> answerList;
}
