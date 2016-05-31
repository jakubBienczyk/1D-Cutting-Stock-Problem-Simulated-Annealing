package neighborhood;

import heurictic.MockHeurictic;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import problemData.MockData;

public class RandomNeighborsGeneratorTest {

    private MockData data = new MockData();
    private List<Integer> currentSolution = new MockHeurictic().createSolution();

    public RandomNeighborsGeneratorTest() {
    }

    @Test
    public void testGeneratedNeighborHasRightStacks() {
        List<Integer> neighbor = generateNeighbor();

        List<Integer> numberOfOrderedStacks = data.getNumberOfOrderedStacks();
        assertTrue(neighbor.size() == numberOfOrderedStacks.stream().reduce(0, (x, y) -> x + y));

        Iterator<Integer> amountIterator = data.getNumberOfOrderedStacks().iterator();
        Iterator<Integer> lengthIterator = data.getOrderedStackLengths().iterator();

        while (amountIterator.hasNext()) {
            int amount = amountIterator.next();
            int length = lengthIterator.next();
            assertTrue(neighbor.stream().filter(x -> x == length).toArray().length == amount);
        }
    }

    @Test
    public void testGeneratedNeighborIsNotTheSame() {
        List<Integer> neighbor = generateNeighbor();

        assertNotSame(neighbor, currentSolution);
    }

    private List<Integer> generateNeighbor() {
        RandomNeighborsGenerator generator = new RandomNeighborsGenerator();
        return generator.generateNeighbor(currentSolution);
    }

}
