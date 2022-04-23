package com.robinfood.polls.useCase;

import com.robinfood.polls.entity.Poll;
import com.robinfood.polls.model.Answer;
import com.robinfood.polls.model.Question;
import com.robinfood.polls.repository.PollRepository;
import com.robinfood.polls.responseDto.PollResponseDto;
import com.robinfood.polls.responseDto.ResponseErrorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PollsUseCase {

    public static final String ERROR_POLL_NOT_EXISTS = "The poll named %s doesn't exist in the records";

    @Autowired
    PollRepository pollRepository;

    public ResponseEntity<Object> getPoll(String pollName){
        Optional<Poll> poll = pollRepository.findByPollName(pollName);

        if(!poll.isPresent()){
            String messageError = String.format(ERROR_POLL_NOT_EXISTS, pollName);
            return ResponseEntity.badRequest().body(new ResponseErrorDto(messageError));
        }
        return ResponseEntity.ok().body(buildPollResponseDTO(poll.get()));
    }

    private PollResponseDto buildPollResponseDTO(Poll poll){
        return PollResponseDto.builder()
            .poll(
                com.robinfood.polls.model.Poll.builder()
                    .pollName(poll.getPollName())
                    .questions(buildQuestionsModel(poll))
                .build()
            )
        .build();
    }

    private List<Question> buildQuestionsModel(Poll poll){
        List<Question> questions = new ArrayList<>();
        if(poll.getQuestionList().size() == 0 ){
            return questions;
        }
        poll.getQuestionList().forEach(question ->
            questions.add(
                Question.builder()
                    .question(question.getQuestion())
                    .type(question.getType().getType())
                    .answers(buildAnswersModel(question))
                .build()
            )
        );

        return questions;
    }

    private List<Answer> buildAnswersModel(com.robinfood.polls.entity.Question question){
        List<Answer> answers = new ArrayList<>();
        if(question.getAnswerList().size() == 0 ){
            return answers;
        }
        question.getAnswerList().forEach(answer ->
            answers.add(
                Answer.builder()
                    .answer(answer.getAnswer())
                    .orderAnswer(answer.getOrderAnswer())
                .build()
            )
        );

        return answers;
    }
}
