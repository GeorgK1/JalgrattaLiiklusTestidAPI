package com.georgkivivali.jalgrattaliiklustestidapi.repository;

import com.georgkivivali.jalgrattaliiklustestidapi.bicycletest.AnswerOption;
import com.georgkivivali.jalgrattaliiklustestidapi.bicycletest.BicycleTest;
import com.georgkivivali.jalgrattaliiklustestidapi.bicycletest.TestCategories;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
@DataMongoTest
@AutoConfigureDataMongo
class BicycleTestRepositoryTest {

    @Autowired
    private BicycleTestRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldFindBicycleTestsByCategory() {
        //given
        AnswerOption answerOption1 = new AnswerOption("Kollane auto", false);
        AnswerOption answerOption2 = new AnswerOption("Roheline auto", false);
        AnswerOption answerOption3 = new AnswerOption("Jalgrattur", true);

        List<AnswerOption> answerOptions = new ArrayList<>();
        answerOptions.add(answerOption1);
        answerOptions.add(answerOption2);
        answerOptions.add(answerOption3);

        BicycleTest bicycleTest = new BicycleTest("Kes ületab esimesena ristmikul teed?", "../assets/test.png", TestCategories.SÕITMINE_RISTMIKEL, answerOptions);
        underTest.save(bicycleTest);
        //when
        List<BicycleTest> foundBicycleTests = underTest.findBicycleTestByCategory(TestCategories.SÕITMINE_RISTMIKEL);
        //then
        assertThat(foundBicycleTests).asList().extracting("category")
                .contains(TestCategories.SÕITMINE_RISTMIKEL);
    }
}