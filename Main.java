
import java.io.BufferedWriter;
import java.io.FileWriter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Chet
 */
public class Main {

    public static double log2(double d) {
        return Math.log(d) / Math.log(2.0);
    }

    /**
     * 
     * @param sorter
     * @param elements
     * @return
     */
    public static long runSort(Sorter sorter, int[] elements) {
        Random rand = new Random();
        long time1 = System.currentTimeMillis();
        int[] returned = sorter.sort(elements);
        long time2 = System.currentTimeMillis();
        
        boolean isCorrect = true;
        for(int i=0;i<returned.length-1;i++){
            if(returned[i]>returned[i+1]){
                isCorrect = false;
            }
        }
        if(!isCorrect){
            System.err.println(sorter.toString() + " is not correct.");
        }
        
        
        return time2 - time1;
    }

    /**
     * Run the simulation
     * @param sorters an array of sorting algorithms to use
     * @param runs the sizes of arrays to sort.
     * @param tries the number of times to try each one.
     * @param generators an array of generators to make different types of arrays.
     * @return a two-dimensional array of results.
     */
    public static Object[][] runTests(Sorter[] sorters, int[] runs, int tries, Generator[] generators) {
        System.out.println("Testing started");

        {//Give basic information
            for (int i = 0; i < sorters.length; i++) {
                System.out.println("Sorter " + i + ":" + sorters[i]);
            }
            for (int i = 0; i < generators.length; i++) {
                System.out.println("Generator" + i + ":" + generators[i]);
            }
            for (int i = 0; i < runs.length; i++) {
                System.out.println("Run" + i + ":" + runs[i]);
            }
            System.out.println("Running each " + tries + " times.");
        }
        //Create the table.
        Object[][] toReturn = new Object[generators.length + (runs.length * generators.length)][2 + (sorters.length * tries)];
        //Generate the tag data for the columns and rows.
        for (int i = 0; i < generators.length; i++) {
            toReturn[i * (runs.length + 1)][0] = "\"" + generators[i].toString() + "\"";//give the sorter title
            toReturn[i * (runs.length + 1)][1] = "\"nlgn\"";
            for (int k = 0; k < sorters.length; k++) {
                for (int l = 1; l <= tries; l++) {
                    toReturn[i * (runs.length + 1)][(k * tries) + l + 1] = "\"" + sorters[k].toString() + l + "\"";
                }
            }
            for (int j = 0; j < runs.length; j++) {
                toReturn[(i * (runs.length + 1)) + (j + 1)][0] = runs[j] + "";//give the int number
                toReturn[(i * (runs.length + 1)) + (j + 1)][1] = nlgn(runs[j]) + "";//Calculate nlgn
            }
        }

        //Run the tests
        System.out.println("**** Running tests ****");
        System.out.println("Generator\tSize\tTry#\tSorter\tTime");
        for (int gen = 0; gen < generators.length; gen++) {
            for (int r = 0; r < runs.length; r++) {
                for (int t = 1; t <= tries; t++) {
                    Generator currentGenerator = generators[gen];
                    int currentRunSize = runs[r];
                    int[] elements = currentGenerator.generate(currentRunSize);
                    for (int sort = 0; sort < sorters.length; sort++) {
                        String val = runSort(sorters[sort], elements)+"";
                        toReturn[(gen*(runs.length+1))+ r + 1][sort*tries + t + 1] = val;
                        System.out.println(generators[gen].toString() + "\t" + runs[r] + "\t" + t + "\t" + sorters[sort].toString() + "\t" + val);
                    }
                }
            }
        }


        return toReturn;
    }

    public static long nlgn(int n) {
        return Math.round(n * log2(n));
    }

    public static void main(String[] args) {
        int[] testingTests = {10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000, 200000, 500000};
        int[] fullTests = {10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000, 200000, 500000, 700000, 1000000, 2000000, 5000000, 7000000, 10000000};
        Sorter[] sorters = {new Quicksort(), new QuickInsertion(), new HoareQuickSort()};
        Generator[] generators = {new RandomGenerator(), new BellCurveGenerator(), new PreSortGenerator(), new ReverseSortedGenerator(), new NearlySortedGenerator()};
        Object[][] toWrite = runTests(sorters, testingTests, 5, generators);
        try {
            FileWriter fw = new FileWriter("output.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int j = 0; j < toWrite.length; j++) {
                for (int k = 0; k < toWrite[j].length; k++) {
                    bw.write((String) toWrite[j][k] + ",");
                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
            System.out.println("Successfully written");
        } catch (IOException ioe) {
            System.out.println("Sorry, file could not be written");
        }
    }
}
