package com.realestateapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ApartmentRaterTest {

    //a parameterized test with different values
    @Test
   // @CsvFileSource
    void should_ReturnCorrectRating_When_CorrectApartment(){

        //given

     /*   List<Apartment> coders = new ArrayList<>();
        coders.add(new Apartment(30, 3000);;
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));
        //double[] expected = {18.52, 29.59, 19.53};
        double[] expected = {18.52, 29.59, 19.53};

        //when
        double[] bmiScores = BMICalculator.getBMIScores(coders);

        //then
        assertArrayEquals(expected, bmiScores);*/
    }

    void should_ReturnErrorValue_When_IncorrectApartment(){

    }

    void should_CalculateAverageRating_When_CorrectApartmentList(){

    }

    void should_ThrowExceptionInCalculateAverageRating_When_EmptyApartmentList(){

    }
}