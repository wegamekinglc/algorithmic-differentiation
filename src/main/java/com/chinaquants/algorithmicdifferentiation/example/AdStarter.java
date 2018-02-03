package com.chinaquants.algorithmicdifferentiation.example;

import com.chinaquants.algorithmicdifferentiation.type.DoubleDerivatives;

import java.util.function.Function;

public class AdStarter {

    static public double f(double[] a) {
        double b1 = a[0] + Math.exp(a[1]);
        double b2 = Math.sin(a[2]) + Math.cos(a[3]);
        double b3 = Math.pow(a[1], 1.5d) + a[3];
        return Math.cos(b1) * b2 + b3;
    }

    static public DoubleDerivatives f_Sad(double[] a) {
        // forward sweep - function
        double b1 = a[0] + Math.exp(a[1]);
        double b2 = Math.sin(a[2]) + Math.cos(a[3]);
        double b3 = Math.pow(a[1], 1.5d) + a[3];
        double b4 = Math.cos(b1) * b2 + b3;

        // forward sweep - derivatives
        int nbA = a.length;
        double[] b1Dot = new double[nbA];
        b1Dot[0] = 1.;
        b1Dot[1] = Math.exp(a[1]);
        double[] b2Dot = new double[nbA];
        b2Dot[2] = Math.cos(a[2]);
        b2Dot[3] = -Math.sin(a[3]);
        double[] b3Dot = new double[nbA];
        b3Dot[1] = 1.5d * Math.sqrt(a[1]);
        b3Dot[3] = 1.;

        double[] b4Dot = new double[nbA];
        for(int i = 0; i < nbA; ++i) {
            b4Dot[i] = -Math.sin(b1) * b2 * b1Dot[i] + Math.cos(b1) * b2Dot[i] + b3Dot[i];
        }
        return new DoubleDerivatives(b4, b4Dot);

    }
}

/** Inner class to write f as a Function. */
class f_Function implements Function<double[], Double> {

    @Override
    public Double apply(double[] x) {
        return AdStarter.f(x);
    }

}
