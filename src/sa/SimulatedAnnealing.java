package sa;

import java.util.List;
import java.util.Random;
import neighborhood.NeighborsGenerator;
import wastesCalculator.WastesCalculatorInterface;

public class SimulatedAnnealing {

    private Random rand;
    private List<Integer> bestSolution;
    private int bestSoultionSize;
    private WastesCalculatorInterface calculator;
    private NeighborsGenerator generator;
    private int innerLoopsNumber;
    private double coolintRatio = 0.95;
    private static double initTemp = 10000;
    private int currentSize;
    private double temp;
    private List<Integer> currentSolution;

    public SimulatedAnnealing(List<Integer> initialSolution, WastesCalculatorInterface calculator, NeighborsGenerator generator) {
        this.bestSolution = initialSolution;
        this.calculator = calculator;
        this.generator = generator;
        rand = new Random();
        setInnerLoopsNumber();
    }

    public List<Integer> getBestSolution() {
        return bestSolution;
    }

    public int calculate(int loopsNumber) {
        bestSoultionSize = calculator.calculate(bestSolution);
        currentSolution = bestSolution;
        currentSize = bestSoultionSize;
        temp = initTemp;
        while (loopsNumber > 0) {
            loopsNumber--;
            doInnerLoops();
            adjustTemp();
        }

        return bestSoultionSize;
    }

    private void doInnerLoops() {
        for (int n = 0; n < innerLoopsNumber; n++) {
            List<Integer> neighbor = generator.generateNeighbor(currentSolution);
            int neighborSize = calculator.calculate(neighbor);
            if (neighborSize <= currentSize)
                changeCurrentSolution(neighbor, neighborSize);
            else if (isApproved(neighborSize))
                changeCurrentSolution(neighbor, neighborSize);
            changeBestSolution();

        }
    }

    private void adjustTemp() {
        temp = temp * coolintRatio;
    }

    private void changeCurrentSolution(List<Integer> newSolution, int newSolutionSize) {
        currentSize = newSolutionSize;
        currentSolution = newSolution;
    }

    private boolean isApproved(int neighborSize) {
        double y = rand.nextDouble();
        return y < Math.exp((currentSize - neighborSize) / temp);
    }

    private void changeBestSolution() {
        if (currentSize < bestSoultionSize) {
            bestSoultionSize = currentSize;
            bestSolution = currentSolution;
        }
    }

    private void setInnerLoopsNumber() {
        innerLoopsNumber = (int) (bestSolution.size() * (1 + Math.log(bestSolution.size())));
        coolintRatio = Math.pow(0.1 / initTemp, innerLoopsNumber);
    }
}
