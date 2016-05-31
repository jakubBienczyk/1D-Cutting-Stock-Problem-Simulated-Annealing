package input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import problemData.Data;

public class Hard28Input implements Input {

    final private Path path = Paths.get(System.getProperty("user.dir"), "/test/inputs/hard28");
    private Iterator<String> iterator;
    private List<Data> dataList;

    @Override
    public void read() throws IOException {
        List<String> lines = Files.readAllLines(path);
        dataList = new ArrayList<>();
        iterator = lines.iterator();
        while (iterator.hasNext()) {
            readNextData();
        }
    }

    public List<Data> getDataList() {
        return dataList;
    }

    private void readNextData() {
        Data data = new Data();
        String name = iterator.next();
        data.setName(name);
        int numberOfOrders = Integer.parseInt(iterator.next().trim());
        int stockLength = Integer.parseInt(iterator.next().trim());
        data.setStockLength(stockLength);
        readOrders(data, numberOfOrders);
        dataList.add(data);
    }

    private void readOrders(Data data, int numberOfOrders) {
        List<Integer> numberOfOrderedStacks = new ArrayList<>();
        List<Integer> orderedStackLengths = new ArrayList<>();
        for (int order = 0; order < numberOfOrders; order++) {
            String[] line = iterator.next().trim().split("\\s+");
            orderedStackLengths.add(Integer.parseInt(line[0]));
            numberOfOrderedStacks.add(Integer.parseInt(line[1]));
        }
        data.setNumberOfOrderedStacks(numberOfOrderedStacks);
        data.setOrderedStackLengths(orderedStackLengths);
    }

}
