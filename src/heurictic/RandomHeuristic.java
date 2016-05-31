package heurictic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import problemData.Data;

public class RandomHeuristic implements Heuristic {

    private Data data;

    public RandomHeuristic(Data data) {
        this.data = data;
    }

    @Override
    public List<Integer> createSolution() {
        List<Integer> solution = new ArrayList<>();
        addAllOrderedStocksToList(solution);
        randomlyMixList(solution);
        return solution;
    }

    private void addAllOrderedStocksToList(List<Integer> list) {
        Iterator<Integer> amountIterator = data.getNumberOfOrderedStacks().iterator();
        Iterator<Integer> lengthIterator = data.getOrderedStackLengths().iterator();

        while (amountIterator.hasNext()) {
            int amount = amountIterator.next();
            int length = lengthIterator.next();

            IntStream.range(0, amount).forEach(x -> list.add(length));
        }
    }
    
    private void randomlyMixList(List<Integer> list) {
        long seed = System.nanoTime();
        Collections.shuffle(list, new Random(seed));
    }

}
