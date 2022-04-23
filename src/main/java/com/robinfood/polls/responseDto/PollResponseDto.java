package com.robinfood.polls.responseDto;

import com.robinfood.polls.model.Poll;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PollResponseDto {

    private Poll poll;

}
