package com.chinaquants.algorithmicdifferentiation.utils;

import java.util.function.Function;

public class FiniteDifferenceFirstOrder {

    public static double[] differentiate(Function<double[], Double> function, double[] x, double epsilon, FiniteDifferenceSchemes scheme) {
        int nbX = x.length;
        double[] derivative = new double[nbX];
        switch (scheme) {
            case FORWARD: {
                Double y0 = function.apply(x);
                for (int i = 0; i < nbX; i++) {
                    double[] xShifted = x.clone();
                    xShifted[i] += epsilon;
                    derivative[i] = (function.apply(xShifted) - y0)/epsilon;
                }
                return derivative;
            }
            case BACKWARD: {
                Double y0 = function.apply(x);
                for(int i = 0; i < nbX; i++) {
                    double[] xShifted = x.clone();
                    xShifted[i] -= epsilon;
                    derivative[i] = (y0 - function.apply(xShifted))/epsilon;
                }
                return derivative;
            }
            case SYMMETRICAL: {
                for(int i = 0; i < nbX; i++) {
                    double[] xShiftedP = x.clone();
                    double[] xShiftedM = x.clone();
                    xShiftedP[i] += epsilon;
                    xShiftedM[i] -= epsilon;
                    derivative[i] = (function.apply(xShiftedP) - function.apply(xShiftedM)) / (2 * epsilon);
                }
                return derivative;
            }
            case FOURTH_ORDER: {
                for(int i = 0; i < nbX; i++) {
                    double[] xShiftedP1 = x.clone();
                    double[] xShiftedM1 = x.clone();
                    double[] xShiftedP2 = x.clone();
                    double[] xShiftedM2 = x.clone();
                    xShiftedP1[i] += epsilon;
                    xShiftedP2[i] += 2 * epsilon;
                    xShiftedM1[i] -= epsilon;
                    xShiftedM2[i] -= 2 * epsilon;
                    derivative[i] = (-function.apply(xShiftedP2) + 8 * function.apply(xShiftedP1)
                            - 8 * function.apply(xShiftedM1) + function.apply(xShiftedM2)) / (12 * epsilon);
                }
                return derivative;
            }
            default:
                throw new IllegalArgumentException(
                        "Finite difference scheme should be FORWARD, BACKWARD, SYMMETRICAL or FOURTH_ORDER");
        }
    }

}
