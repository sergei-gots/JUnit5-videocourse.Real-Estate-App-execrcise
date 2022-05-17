package com.realestateapp;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RandomApartmentGenerator {

	private static final double MAX_MULTIPLIER = 4.0;

	private double minArea;
	private BigDecimal minPricePerSquareMeter;

	public RandomApartmentGenerator() {
		super();
		this.minArea = 30.0;
		this.minPricePerSquareMeter = new BigDecimal(3000.0);
	}

	public RandomApartmentGenerator(double minArea, BigDecimal minPricePerSquareMeter) {
		super();
		this.minArea = minArea;
		this.minPricePerSquareMeter = minPricePerSquareMeter;
	}

	public Apartment generate() {
		double maxArea = minArea * MAX_MULTIPLIER;
		BigDecimal maxPricePerSquareMeter = minPricePerSquareMeter.multiply(new BigDecimal(MAX_MULTIPLIER));

		double area = Math.round((minArea + Math.random() * (maxArea - minArea)) * 10) / 10;
		BigDecimal pricePerSquareMeter = minPricePerSquareMeter
				.add((new BigDecimal(Math.random()).multiply(maxPricePerSquareMeter.subtract(minPricePerSquareMeter))));
		BigDecimal price = pricePerSquareMeter.multiply(new BigDecimal(area)).setScale(1, RoundingMode.FLOOR);
		return new Apartment(area, price);
	}
}
