package com.georgkivivali.jalgrattaliiklustestidapi.bicycletest;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * This is a bicycle test model
 */

@Data
@Document
public class BicycleTest {

        @Id
        private String id;
        private String questionText;
        private String imgPath;
        private TestCategories category;
        private List<AnswerOption> answerOptionList;

        public BicycleTest(String questionText, String imgPath, TestCategories category, List<AnswerOption> answerOptionList) {
                this.questionText = questionText;
                this.imgPath = imgPath;
                this.category = category;
                this.answerOptionList = answerOptionList;
        }
}