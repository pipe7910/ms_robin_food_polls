package com.robinfood.polls;


import com.robinfood.polls.useCase.PollsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/v1/polls/")
public class PollsController {

    @Autowired
    PollsUseCase pollsUseCase;

    @GetMapping("/{pollName}")
    public ResponseEntity<Object> getPoll(@PathVariable("pollName") String pollName){
        return pollsUseCase.getPoll(pollName);
    }


}

