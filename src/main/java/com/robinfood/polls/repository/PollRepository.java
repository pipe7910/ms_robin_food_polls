package com.robinfood.polls.repository;

import com.robinfood.polls.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {

    Optional<Poll> findByPollName(String pollName);

}
