package com.robinfood.polls.useCase;

import com.robinfood.polls.entity.Answer;
import com.robinfood.polls.entity.Poll;
import com.robinfood.polls.entity.Question;
import com.robinfood.polls.repository.PollRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PollsUseCaseTest {
    @InjectMocks
    PollsUseCase pollsUseCase = new PollsUseCase();

    @Mock
    PollRepository pollRepository;

    @Test
    void getPollTest(){
        MockitoAnnotations.initMocks(this);
        Poll poll = new Poll(1L, "any-poll", new ArrayList<>());
        Optional<Poll> optionalPoll = Optional.of(poll);
        Mockito.when(pollRepository.findByPollName(Mockito.any(String.class))).thenReturn(optionalPoll);
        Assertions.assertNotNull(pollsUseCase.getPoll("any-poll"));
    }

    @Test
    void getPollTest2(){
        MockitoAnnotations.initMocks(this);
        Question question = new Question(1L,"any-question", "any-type", null, new ArrayList<>());
        List<Question> questions = new ArrayList<>();
        questions.add(question);
        Poll poll = new Poll(1L, "any-poll", questions);
        Optional<Poll> optionalPoll = Optional.of(poll);
        Mockito.when(pollRepository.findByPollName(Mockito.any(String.class))).thenReturn(optionalPoll);
        Assertions.assertNotNull(pollsUseCase.getPoll("any-poll"));
    }

    @Test
    void getPollTest3(){
        MockitoAnnotations.initMocks(this);
        Answer answer = new Answer(1L,1,"any-answer", null);
        List<Answer> answers = new ArrayList<>();
        answers.add(answer);
        Question question = new Question(1L,"any-question", "any-type", null, answers);
        List<Question> questions = new ArrayList<>();
        questions.add(question);
        Poll poll = new Poll(1L, "any-poll", questions);
        Optional<Poll> optionalPoll = Optional.of(poll);
        Mockito.when(pollRepository.findByPollName(Mockito.any(String.class))).thenReturn(optionalPoll);
        Assertions.assertNotNull(pollsUseCase.getPoll("any-poll"));
    }

    @Test
    void getPollTest4(){
        MockitoAnnotations.initMocks(this);
        Optional<Poll> optionalPoll = Optional.empty();
        Mockito.when(pollRepository.findByPollName(Mockito.any(String.class))).thenReturn(optionalPoll);
        Assertions.assertNotNull(pollsUseCase.getPoll("any-poll"));
    }
}
