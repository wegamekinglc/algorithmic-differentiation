package com.chinaquants.algorithmicdifferentiation.type;

public class DoubleSad {
    private final double value;
    private final int nbDerivatives;
    private final double[] derivatives;

    public DoubleSad(double value, double[] derivatives) {
        this.value = value;
        this.derivatives = derivatives;
        nbDerivatives = derivatives.length;
    }

    static public DoubleSad[] init(double[] inputs) {
        int nbInputs = inputs.length;
        DoubleSad[] init = new DoubleSad[nbInputs];
        for(int i = 0; i != nbInputs; ++i) {
            double[] initDot = new double[nbInputs];
            initDot[i] = 1.0;
            init[i] = new DoubleSad(inputs[i], initDot);
        }
        return init;
    }

    public double value() { return value;}
    public int getNbDerivatives() { return nbDerivatives;}
    public double[] derivatives() { return derivatives;}
}
