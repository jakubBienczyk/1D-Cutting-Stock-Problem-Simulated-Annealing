package neighborhood;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomNeighborsGenerator implements NeighborsGenerator {

    private Random rand;

    public RandomNeighborsGenerator() {
        rand = new Random();
    }

    @Override
    public List<Integer> generateNeighbor(List<Integer> currentSolution) {
        int size = currentSolution.size();
        Integer[] currentSolutionArray = new Integer[size];
        currentSolutionArray = currentSolution.toArray(currentSolutionArray);
        int index1 = rand.nextInt(size);
        int index2 = rand.nextInt(size);
        int element = currentSolutionArray[index1];
        currentSolutionArray[index1] = currentSolutionArray[index2];
        currentSolutionArray[index2] = element;
        return Arrays.asList(currentSolutionArray);
    }

}
