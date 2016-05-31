package heurictic;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import problemData.Data;

public class RandomHeuristicTest {


    @Test
    public void testCreateSolution() {
        RandomHeuristic instance = new RandomHeuristic(createMockData());
        List<Integer> soultion = instance.createSolution();
        assertTrue(soultion.size() == 13);
        assertTrue(soultion.stream().filter(x -> x == 5).toArray().length == 1);
        assertTrue(soultion.stream().filter(x -> x == 10).toArray().length == 5);
        assertTrue(soultion.stream().filter(x -> x == 15).toArray().length == 7);
        assertTrue(soultion.stream().filter(x -> x != 5 && x != 10 && x != 15).toArray().length == 0);
    }

    private Data createMockData() {
        List orderedStacksLength = new ArrayList();
        List numberOfOrderedStacks = new ArrayList();
        orderedStacksLength.add(5);
        numberOfOrderedStacks.add(1);
        orderedStacksLength.add(10);
        numberOfOrderedStacks.add(5);
        orderedStacksLength.add(15);
        numberOfOrderedStacks.add(7);
        Data mock = new Data(10, orderedStacksLength, numberOfOrderedStacks);
        return mock;
    }

}
