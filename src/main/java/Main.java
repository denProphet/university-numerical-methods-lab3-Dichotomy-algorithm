import algorithm.DichotomyAlgorithmSolver;
import exceptions.IllegalDataStructureException;
import reader.ArrayFileReader;


import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Дисципліна: чисельні методи. Лабораторна робота 3. Яровой Денис
 * Варіант 20: –1,6х3 – 0,2х2 – 1,9х + 1,3 = 0
 * <p>
 * Вимоги до проекту:
 * Написати програму для розв’язання кубічного рівняння
 * методом дихотомії за умови, що точність рішення ε = 10-4.
 * <p>
 * Вхідні дані знаходяться у файлі (файл src/main/resources)
 * <p>
 * Структура файлу з даними:
 * 1 рядок = 1 значення.
 * Дозволено десяткові роздільники "." та ","
 * Дозволено порожні рядки
 *
 * @author Den Yarovoy
 * @version 1.1
 **/


public class Main {
    public static void main(String[] args) throws IOException {

        /**
         *
         * Get coefficients and interval data from external files using reader&parser
         * check structure
         * solve specific algorithm
         */
        ArrayFileReader arrayFileReader = new ArrayFileReader();

        try {
            List<Double> coefficients =
                    arrayFileReader.getDoubleList(new File("src/main/resources/coefficientsFromXcubed.txt"));
            List<Double> interval =
                    arrayFileReader.getDoubleList(new File("src/main/resources/interval.txt"));
            List<Double> solutionList =
                    arrayFileReader.getDoubleList(new File("src/main/resources/solution.txt"));

            /**
             * check initial values data format
             * */
            if (coefficients.size() != 4 ||
                    solutionList.size() !=1 ||
                    interval.size() != 2) throw new IllegalDataStructureException();


            /**
             * initialize epsilon (accuracy) to solve algorithm
             * */
            double accuracyEpsilon = 0.001;

            /**
             * initialize equation solution
             * */
        double solution = solutionList.get(0);

            /**
             * solve algorithm
             * get result
             * show it
             * */

            DichotomyAlgorithmSolver algorithmSolver = new DichotomyAlgorithmSolver(interval.get(0),
                    interval.get(1), coefficients, solution, accuracyEpsilon);

            System.out.printf("Result: %.4f", algorithmSolver.getResult());
        } catch (IllegalDataStructureException e) {
            System.err.println("Wrong initial data structure.Required format:" +
                    " 2 values for interval, 5 values for coefficients, 1 value for solution " +
                    "Every value has to be started from next line ");
        } catch (NumberFormatException e) {
            System.err.println("Illegal file data format. Required format: decimal values. " +
                    "Every value has to be started from next line");
        }
    }
}

