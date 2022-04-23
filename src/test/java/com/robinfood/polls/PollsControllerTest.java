package com.robinfood.polls;

import com.robinfood.polls.entity.Poll;
import com.robinfood.polls.useCase.PollsUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class PollsControllerTest {

    @InjectMocks
    PollsController pollsController;

    @Mock
    PollsUseCase pollsUseCase;

    @Test
    void getPollControllerTest(){
        MockitoAnnotations.initMocks(this);
        Mockito.when(pollsUseCase.getPoll(Mockito.any(String.class))).thenReturn(ResponseEntity.ok().body("OK"));
        Assertions.assertNotNull(pollsController.getPoll("any-poll"));
    }

    @Test
    public void main() {
        PollsApplication.main(new String[] {});
    }

}
