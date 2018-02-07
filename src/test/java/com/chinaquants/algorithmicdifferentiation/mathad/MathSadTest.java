package com.chinaquants.algorithmicdifferentiation.mathad;

import static org.testng.AssertJUnit.assertEquals;
import cern.jet.random.Normal;
import com.chinaquants.algorithmicdifferentiation.type.DoubleSad;
import org.testng.annotations.Test;

public class MathSadTest {
    private static final double VALUE_1 = 123.4;
    private static final double VALUE_2 = 3.2;
    private static final double[] DERIVATIVES_1 = {1.1, 2.2, 3.3};
    private static final double[] DERIVATIVES_2 = {2.1, 3.2, 4.3};
    private static final DoubleSad OBJECT_1 = new DoubleSad(VALUE_1, DERIVATIVES_1);
    private static final DoubleSad OBJECT_2 = new DoubleSad(VALUE_2, DERIVATIVES_2);

    private static final double TOLERANCE_DOUBLE = 1.0e-12;

    private static final Normal NORMAL = new Normal(0.0, 1.0, null);

    @Test
    public void Plus() {
        DoubleSad plus = MathSad.plus(OBJECT_1, OBJECT_2);
        assertEquals("DoubleSad: plus", VALUE_1 + VALUE_2, plus.value(), TOLERANCE_DOUBLE);
        assertEquals("DoubleSad: plus", DERIVATIVES_1.length, plus.getNbDerivatives());
        for(int i = 0; i != DERIVATIVES_1.length; ++i)
            assertEquals("DoubleSad: plus", DERIVATIVES_1[i] + DERIVATIVES_2[i], plus.derivatives()[i], TOLERANCE_DOUBLE);
    }
}
