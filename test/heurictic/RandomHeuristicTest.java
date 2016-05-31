package heurictic;

import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import problemData.MockData;

public class RandomHeuristicTest {
    private MockData data = new MockData();

    @Test
    public void testCreateSolution() {
        RandomHeuristic instance = new RandomHeuristic(data);
        List<Integer> soultion = instance.createSolution();
        
        List<Integer> numberOfOrderedStacks = data.getNumberOfOrderedStacks();
        assertTrue(soultion.size() == numberOfOrderedStacks.stream().reduce(0, (x,y) -> x+y));
        
        Iterator<Integer> amountIterator = data.getNumberOfOrderedStacks().iterator();
        Iterator<Integer> lengthIterator = data.getOrderedStackLengths().iterator(); 
        
        while (amountIterator.hasNext()) {
            int amount = amountIterator.next();
            int length = lengthIterator.next();
            assertTrue(soultion.stream().filter(x -> x == length).toArray().length == amount);
        }
    }

}
