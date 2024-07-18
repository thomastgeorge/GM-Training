package com.grayMatter;

public abstract class ArithemeticCalculator extends AbstractCalculator {

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
	public abstract float pow(float a, float b);

	@Override
	public abstract float sqrt(float a);
	
}
