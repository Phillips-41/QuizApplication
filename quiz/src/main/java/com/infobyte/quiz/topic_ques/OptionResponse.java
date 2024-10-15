package com.infobyte.quiz.topic_ques;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OptionResponse {
    private Integer optionId;   // Useful for frontend tracking or updates
    private String optionText;  // The actual text of the option
    private boolean isSelected; // Whether the user has selected this option (useful for future)
}

