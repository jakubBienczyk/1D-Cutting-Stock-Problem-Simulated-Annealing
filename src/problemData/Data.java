package problemData;

import java.util.List;

public class Data {

    private final int stockLength;
    private final List<Integer> orderedStackLengths;
    private final List<Integer> numberOfOrderedStacks;

    public Data(int stockLength, List<Integer> orderedStackLengths, List<Integer> numberOfOrderedStacks) {
        this.stockLength = stockLength;
        this.orderedStackLengths = orderedStackLengths;
        this.numberOfOrderedStacks = numberOfOrderedStacks;
    }

    public int getStockLength() {
        return stockLength;
    }

    public List<Integer> getOrderedStackLengths() {
        return orderedStackLengths;
    }

    public List<Integer> getNumberOfOrderedStacks() {
        return numberOfOrderedStacks;
    }

}
