package heurictic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import problemData.MockData;

public class MockHeurictic implements Heuristic {

    private MockData data = new MockData();

    @Override
    public List<Integer> createSolution() {
        List<Integer> solution = new ArrayList<>();
        addAllOrderedStocksToList(solution);
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
}
