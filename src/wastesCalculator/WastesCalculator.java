package wastesCalculator;

import java.util.Iterator;
import java.util.List;
import problemData.DataInterface;

public class WastesCalculator implements WastesCalculatorInterface {

    private DataInterface data;

    public WastesCalculator(DataInterface data) {
        this.data = data;
    }

    @Override
    public int calculate(List<Integer> currentSolution) {
        int waste = 0;

        Iterator<Integer> iterator = currentSolution.iterator();
        int usedStack = 0;
        while (iterator.hasNext()) {
            int stackLength = iterator.next();
            if (usedStack - stackLength < 0) {
                waste++;
                usedStack = data.getStockLength() - stackLength;
            } else
                usedStack = usedStack - stackLength;
        }

        return waste;
    }

}
