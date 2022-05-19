package com.realestateapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentRaterTest {

    //a parameterized test with different values
    @ParameterizedTest(name = "area={0}, price={1}, pricePerSqM={2}, givenRating={3}")
    @CsvFileSource(resources = "apartment-rater-test-input-data.csv", numLinesToSkip = 1)
    void should_ReturnCorrectRating_When_CorrectApartment(Double area, BigDecimal price, Double pricePerSqM, int expectedRating){

        //given
        Apartment apartment = new Apartment(area, price);

        //when
        int actualRating = ApartmentRater.rateApartment(apartment);

        //then
        assertEquals(actualRating, expectedRating);
    }

    void should_ReturnErrorValue_When_IncorrectApartment(){

    }

    void should_CalculateAverageRating_When_CorrectApartmentList(){

    }

    void should_ThrowExceptionInCalculateAverageRating_When_EmptyApartmentList(){

    }
}