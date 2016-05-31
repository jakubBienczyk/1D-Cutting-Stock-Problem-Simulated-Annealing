package sa;

import heurictic.RandomHeuristic;
import input.Hard28Input;
import java.io.IOException;
import java.util.List;
import neighborhood.NeighborsGenerator;
import neighborhood.RandomNeighborsGenerator;
import problemData.Data;
import wastesCalculator.WastesCalculator;
import wastesCalculator.WastesCalculatorInterface;

public class Main {

    public static void main(String[] args) throws IOException {
        Hard28Input input = new Hard28Input();
        input.read();
        List<Data> dataList = input.getDataList();
        for (Data data : dataList) {
            List<Integer> solution = new RandomHeuristic(data).createSolution();
            WastesCalculatorInterface calculator = new WastesCalculator(data);
            NeighborsGenerator neighborsGenerator = new RandomNeighborsGenerator();
            SimulatedAnnealing annealing = new SimulatedAnnealing(solution, calculator, neighborsGenerator);
            int result = annealing.calculate(1000000);
            System.out.println(data.getName() + ": " + result);
        }

    }

}
