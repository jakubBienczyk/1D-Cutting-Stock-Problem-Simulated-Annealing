package problemData;

import java.util.ArrayList;
import java.util.List;

public class MockData implements DataInterface {

    @Override
    public int getStockLength() {
        return 25;
    }

    @Override
    public List<Integer> getOrderedStackLengths() {
        List orderedStacksLength = new ArrayList();
        orderedStacksLength.add(5);
        orderedStacksLength.add(10);
        orderedStacksLength.add(15);
        return orderedStacksLength;
    }

    @Override
    public List<Integer> getNumberOfOrderedStacks() {
        List numberOfOrderedStacks = new ArrayList();
        numberOfOrderedStacks.add(1);
        numberOfOrderedStacks.add(5);
        numberOfOrderedStacks.add(7);
        return numberOfOrderedStacks;
    }

}
