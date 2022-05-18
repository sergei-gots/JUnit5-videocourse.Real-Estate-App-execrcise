package com.realestateapp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class RandomApartmentGeneratorTest {
    //since values are randomly generated, the tests will be repeated multiple times:
    static private final double MAX_MULTIPLIER = 4.0;

    static private final double MIN_AREA = 30.0;
    static private final double MAX_AREA = MIN_AREA * MAX_MULTIPLIER;
    static private final double MIN_PRICE_PRO_SQM = 3000.0;
    static private final double MAX_PRICE_PRO_SQM = MIN_PRICE_PRO_SQM * MAX_MULTIPLIER;

    static private final double MIN_MIN_AREA = 10.0;
    static private final double MAX_MIN_AREA = 1000.0;
    static private final double MIN_MIN_PRICE_PRO_SQM = 1000.0;
    static private final double MAX_MIN_PRICE_PRO_SQM = 10000.0;




    static RandomApartmentGenerator defaultRandomApartmentGenerator;

    @BeforeAll
    static void createRandomApartmenGenerator(){
        //given
        defaultRandomApartmentGenerator = new RandomApartmentGenerator();
        System.out.println("Random Apartment Generator - Test");
        System.out.println("MIN_AREA = " + MIN_AREA);
        System.out.println("MAX_AREA = " + MAX_AREA);
        System.out.println("MIN_PRICE_PRO_SQM = " + MIN_PRICE_PRO_SQM);
        System.out.println("MAX_PRICE_PRO_SQM = " + MAX_PRICE_PRO_SQM);
    }

    @RepeatedTest(value = 100)
    void should_GenerateCorrectApartment_When_DefaultMinAreaMinPrice(){

        //given
//
        //when
        Apartment apartment = defaultRandomApartmentGenerator.generate();
        double area = apartment.getArea();
        BigDecimal price = apartment.getPrice();
        double pricePerSquareMeter = price.doubleValue() / area;

        //then
        assertTrue(area >= MIN_AREA && area <= MAX_AREA);
        assertTrue(pricePerSquareMeter >= MIN_PRICE_PRO_SQM && pricePerSquareMeter <= MAX_PRICE_PRO_SQM);

    }

    static double generateRandomMinArea(){
        return Math.round(MIN_MIN_AREA + (MAX_MIN_AREA - MIN_MIN_AREA) * Math.random());
    }

    static BigDecimal generateMinPricePerSquareMeter(){
        return new BigDecimal(Math.round(MIN_MIN_PRICE_PRO_SQM
                + (MAX_MIN_PRICE_PRO_SQM - MIN_MIN_PRICE_PRO_SQM) * Math.random()));
    }

    @RepeatedTest(value = 1000)
    void should_GenerateCorrectApartment_When_CustomMinAreaMinPrice(){
        //given
        double minArea = generateRandomMinArea();
        BigDecimal minPricePerSquareMeter = generateMinPricePerSquareMeter();
        System.out.print("minArea = " + minArea);
        System.out.println("; minPricePerSquareMeter = " + minPricePerSquareMeter);

        RandomApartmentGenerator randomApartmentGenerator
                = new RandomApartmentGenerator(minArea, minPricePerSquareMeter);
        //when
        Apartment apartment = randomApartmentGenerator.generate();
        double area = apartment.getArea();
        BigDecimal price = apartment.getPrice();
        double pricePerSquareMeter = price.doubleValue() / area;

        //then
        assertTrue(area >= minArea && area <= minArea * MAX_MULTIPLIER);
        assertTrue(pricePerSquareMeter >= minPricePerSquareMeter.doubleValue()
                && pricePerSquareMeter <= minPricePerSquareMeter.doubleValue() * MAX_MULTIPLIER);

    }

}