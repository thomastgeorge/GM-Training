package com.grayMatter;

public class ScientificCalculator extends ArithemeticCalculator{

	@Override
	public float pow(float a, float b) {
		return (float) Math.pow(a, b);
	}
	
	@Override
	public float sqrt(float a) {
		return (float) Math.sqrt(a);
	}
}
