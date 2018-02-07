package com.chinaquants.algorithmicdifferentiation.mathad;

import cern.jet.random.Normal;
import com.opengamma.strata.collect.ArgChecker;
import com.chinaquants.algorithmicdifferentiation.type.DoubleSad;

public class MathSad {
    private static final Normal NORMAL = new Normal(0.0, 1.0, null);

    public static DoubleSad plus(DoubleSad d1, DoubleSad d2) {
        int nbDerivatives = d1.getNbDerivatives();
        ArgChecker.isTrue(d2.getNbDerivatives() == nbDerivatives, "derivative length should be equal");
        double valueOutput = d1.value() + d2.value();
        double[] derivativesOutput = new double[nbDerivatives];
        for(int i = 0; i != nbDerivatives; ++i)
            derivativesOutput[i] = d1.derivatives()[i] + d2.derivatives()[i];
        return new DoubleSad(valueOutput, derivativesOutput);
    }
}
