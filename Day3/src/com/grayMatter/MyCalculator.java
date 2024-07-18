package com.grayMatter;

public class MyCalculator implements CalculatorInterface, MyScientificCalculator {
	@Override
	public float add(float a, float b) {
		return a+b;
	}
	
	@Override
	public float sub(float a, float b) {
		return a-b;
	}
	
	@Override
	public float mul(float a, float b) {
		return a*b;
	}
	
	@Override
	public float div(float a, float b) {
		return a/b;
	}

	@Override
	public float pow(float a, float b) {
		return (float) Math.pow(a, b);
	}
	
	@Override
	public float sqrt(float a) {
		return (float) Math.sqrt(a);
	}
}
