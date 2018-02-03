package com.chinaquants.algorithmicdifferentiation.example;

import com.chinaquants.algorithmicdifferentiation.type.DoubleDerivatives;
import com.chinaquants.algorithmicdifferentiation.utils.FiniteDifferenceFirstOrder;
import com.chinaquants.algorithmicdifferentiation.utils.FiniteDifferenceSchemes;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertArrayEquals;
import org.testng.annotations.Test;

public class AdStarterTest {
    static private final double[][] A = {
            {0.0, 1.0, 2.0, 3.0},
            {1.0, 2.0, 3.0, 4.0},
            {0.5, 0.1, -0.5, 0.0},
            {2.0, 2.0, 2.0, 2.0},
            {5.0, 2.0, -5.0, 6.0}
    };

    static private final int NB_TESTS = A.length;
    static private final double EPSILON = 1.e-6;
    static private final double TOLERANCE_VALUE = 1.e-6;
    static private final double TOLERANCE_DELTA_1 = 1.e-2;
    static private final double TOLERANCE_DELTA_2 = 1.e-7;

    @Test
    public void derivativesCorrectness() {
        for(int i =0; i < NB_TESTS; ++i) {
            double f = AdStarter.f(A[i]);
            double[] dFwd = FiniteDifferenceFirstOrder.differentiate(new f_Function(), A[i], EPSILON, FiniteDifferenceSchemes.FORWARD);
            DoubleDerivatives dSad = AdStarter.f_Sad(A[i]);
            assertEquals("adStarterAnalysis " + i, f, dSad.value(), TOLERANCE_VALUE);
            assertArrayEquals("adStarterAnalysis " + i, dFwd, dSad.derivatives(), TOLERANCE_DELTA_1);
        }
    }
}
