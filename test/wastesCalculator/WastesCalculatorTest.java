package wastesCalculator;

import heurictic.MockHeurictic;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import problemData.MockData;

public class WastesCalculatorTest {
    
    public WastesCalculatorTest() {
    }

    @Test
    public void testCalculate() {
        List<Integer> currentSolution = new MockHeurictic().createSolution();
        WastesCalculator wastesCalculator = new WastesCalculator(new MockData());
        int expResult = 9;
        int result = wastesCalculator.calculate(currentSolution);
        assertEquals(expResult, result);
    }
    
}
