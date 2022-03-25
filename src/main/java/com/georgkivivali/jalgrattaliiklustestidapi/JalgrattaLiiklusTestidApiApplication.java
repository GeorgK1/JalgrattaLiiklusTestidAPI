package com.georgkivivali.jalgrattaliiklustestidapi;

import com.georgkivivali.jalgrattaliiklustestidapi.bicycletest.BicycleTest;
import com.georgkivivali.jalgrattaliiklustestidapi.bicycletest.AnswerOption;
import com.georgkivivali.jalgrattaliiklustestidapi.bicycletest.TestCategories;
import com.georgkivivali.jalgrattaliiklustestidapi.repository.BicycleTestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JalgrattaLiiklusTestidApiApplication {

    public static void main(String[] args) {


        SpringApplication.run(JalgrattaLiiklusTestidApiApplication.class, args);
    }
    /*
    @Bean
    CommandLineRunner runner(BicycleTestRepository repository) {
        return args -> {
            AnswerOption answerOption1 = new AnswerOption("Kollane auto", false);
            AnswerOption answerOption2 = new AnswerOption("Roheline auto", false);
            AnswerOption answerOption3 = new AnswerOption("Jalgrattur", true);

            List<AnswerOption> answerOptions = new ArrayList<>();
            answerOptions.add(answerOption1);
            answerOptions.add(answerOption2);
            answerOptions.add(answerOption3);

            BicycleTest bicycleTest = new BicycleTest("Kes ületab esimesena ristmikul teed?", "../assets/test.png", TestCategories.SÕITMINE_RISTMIKEL, answerOptions);

            repository.insert(bicycleTest);
            List<BicycleTest> foundTest = repository.findBicycleTestByCategory(TestCategories.SÕITMINE_RISTMIKEL);

        };


    }
*/
}
