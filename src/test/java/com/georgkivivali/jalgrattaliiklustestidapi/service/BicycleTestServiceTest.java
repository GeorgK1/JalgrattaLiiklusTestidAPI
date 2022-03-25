package com.georgkivivali.jalgrattaliiklustestidapi.service;

import com.georgkivivali.jalgrattaliiklustestidapi.bicycletest.AnswerOption;
import com.georgkivivali.jalgrattaliiklustestidapi.bicycletest.BicycleTest;
import com.georgkivivali.jalgrattaliiklustestidapi.bicycletest.TestCategories;
import com.georgkivivali.jalgrattaliiklustestidapi.repository.BicycleTestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BicycleTestServiceTest {

    @Mock
    private BicycleTestRepository bicycleTestRepository;
    private BicycleTestService underTest;


    @BeforeEach
    void setUp() {
        underTest = new BicycleTestService(bicycleTestRepository);
    }

    @Test
    void canGetAllBicycleTests() {
        //when
        underTest.getAllBicycleTests();
        //then
        verify(bicycleTestRepository).findAll();
    }

    @Test
    void canAddTest() {
        //given
        AnswerOption answerOption1 = new AnswerOption("Kollane auto", false);
        AnswerOption answerOption2 = new AnswerOption("Roheline auto", false);
        AnswerOption answerOption3 = new AnswerOption("Jalgrattur", true);

        List<AnswerOption> answerOptions = new ArrayList<>();
        answerOptions.add(answerOption1);
        answerOptions.add(answerOption2);
        answerOptions.add(answerOption3);

        BicycleTest bicycleTest = new BicycleTest("Kes ületab esimesena ristmikul teed?", "../assets/test.png", TestCategories.SÕITMINE_RISTMIKEL, answerOptions);
        //when
        underTest.addNewBicycleTest(bicycleTest);
        //then
        ArgumentCaptor<BicycleTest> bicycleTestArgumentCaptor =
                ArgumentCaptor.forClass(BicycleTest.class);

        verify(bicycleTestRepository).save(bicycleTestArgumentCaptor.capture());

        BicycleTest capturedBicycleTest = bicycleTestArgumentCaptor.getValue();

        assertThat(capturedBicycleTest).isEqualTo(bicycleTest);
    }
}