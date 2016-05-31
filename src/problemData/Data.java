package problemData;

import java.util.List;

public class Data implements DataInterface {

    private int stockLength;
    private List<Integer> orderedStackLengths;
    private List<Integer> numberOfOrderedStacks;
    private String name;

    public void setStockLength(int stockLength) {
        this.stockLength = stockLength;
    }

    public void setOrderedStackLengths(List<Integer> orderedStackLengths) {
        this.orderedStackLengths = orderedStackLengths;
    }

    public void setNumberOfOrderedStacks(List<Integer> numberOfOrderedStacks) {
        this.numberOfOrderedStacks = numberOfOrderedStacks;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getStockLength() {
        return stockLength;
    }

    @Override
    public List<Integer> getOrderedStackLengths() {
        return orderedStackLengths;
    }

    @Override
    public List<Integer> getNumberOfOrderedStacks() {
        return numberOfOrderedStacks;
    }

    public String getName() {
        return name;
    }

}
