package com.chinaquants.algorithmicdifferentiation.type;

public class DoubleDerivatives {
    private final double value;
    private final double[] derivatives;

    public DoubleDerivatives(double value, double[] derivatives) {
        this.value = value;
        this.derivatives = derivatives;
    }

    public double value() { return value;}
    public double[] derivatives() { return derivatives;}
}
