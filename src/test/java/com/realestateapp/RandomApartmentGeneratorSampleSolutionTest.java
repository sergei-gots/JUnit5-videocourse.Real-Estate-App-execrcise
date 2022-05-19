package com.realestateapp;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

class RandomApartmentGeneratorSampleSolutionTest {

	private static final double MAX_MULTIPLIER = 4.0;
	
	@Nested
	class GeneratorDefaultParamsTests {
		
		private RandomApartmentGenerator generator;
		
		@BeforeEach
		void setup() {
			this.generator = new RandomApartmentGenerator();
		}
		
		@RepeatedTest(10)
		void should_GenerateCorrectApartment_When_DefaultMinAreaMinPrice() {
			
			// given
			double minArea = 30.0;
			double maxArea = minArea * MAX_MULTIPLIER;
			BigDecimal minPricePerSquareMeter = new BigDecimal(3000.0);
			BigDecimal maxPricePerSquareMeter = minPricePerSquareMeter.multiply(new BigDecimal(MAX_MULTIPLIER));
			
			// when
			Apartment apartment = generator.generate();
			
			// then
			BigDecimal maxApartmentPrice = new BigDecimal(apartment.getArea()).multiply(maxPricePerSquareMeter);
			BigDecimal minApartmentPrice = new BigDecimal(apartment.getArea()).multiply(minPricePerSquareMeter);
			assertAll(
				() -> assertTrue(apartment.getArea() >= minArea),
				() -> assertTrue(apartment.getArea() <= maxArea),
				() -> assertTrue(apartment.getPrice().compareTo(minApartmentPrice) >= 0),
				() -> assertTrue(apartment.getPrice().compareTo(maxApartmentPrice) <= 0)
			);
		}
	}
	
	@Nested
	class GeneratorCustomParamsTests {
		
		private RandomApartmentGenerator generator;
		private double minArea = 15.0;
		private BigDecimal minPricePerSquareMeter = new BigDecimal(5000.0);
		
		@BeforeEach
		void setup() {
			this.generator = new RandomApartmentGenerator(minArea, minPricePerSquareMeter);
		}
		
		@RepeatedTest(10)
		void should_GenerateCorrectApartment_When_CustomMinAreaMinPrice() {
			
			// given
			double minArea = this.minArea;
			double maxArea = minArea * MAX_MULTIPLIER;
			BigDecimal minPricePerSquareMeter = this.minPricePerSquareMeter;
			BigDecimal maxPricePerSquareMeter = minPricePerSquareMeter.multiply(new BigDecimal(MAX_MULTIPLIER));
			
			// when
			Apartment apartment = generator.generate();
			
			// then
			BigDecimal maxApartmentPrice = new BigDecimal(apartment.getArea()).multiply(maxPricePerSquareMeter);
			BigDecimal minApartmentPrice = new BigDecimal(apartment.getArea()).multiply(minPricePerSquareMeter);
			assertAll(
				() -> assertTrue(apartment.getArea() >= minArea),
				() -> assertTrue(apartment.getArea() <= maxArea),
				() -> assertTrue(apartment.getPrice().compareTo(minApartmentPrice) >= 0),
				() -> assertTrue(apartment.getPrice().compareTo(maxApartmentPrice) <= 0)
			);
		}
	}
}
