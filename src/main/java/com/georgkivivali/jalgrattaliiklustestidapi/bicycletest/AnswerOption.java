package com.georgkivivali.jalgrattaliiklustestidapi.bicycletest;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 This is an answeroption entity made using Java 16 record. This encapsulates the data of each answer option for a test.
 */
@Data
@AllArgsConstructor
public class AnswerOption{
    private String answerText;
    private Boolean isCorrect;
}
        

