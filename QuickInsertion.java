/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * QuickInsertion.java
 *
 * [Class Information]
 *
 * @author Chet Mancini
 * Wheaton College, COURSE, SEASON YEAR
 * TASK
 * Oct 28, 2008
 */
public class QuickInsertion implements Sorter {

    public int[] sort(int[] array){
        quicksort(array, 0, array.length - 1);
        return array;
    }

    /**
     * @param a
     * @param left
     * @param right 
     */
    public void quicksort(int[] a, int left, int right){
        if(right - left < 10){
            insertion(a, left, right);
            return;
        }else{
            int i = partition(a, left, left + (right - left) / 2);
            quicksort(a, left, i - 1);
            quicksort(a, i + 1, right);
        }
    }

    public int partition(int[] array, int p, int r){
        int x = array[r]; // x is the pivot
        int i = p - 1;
        for(int j = p; j < r; j++){
            if(array[j] <= x){
                i++;
                int swap = array[i];
                array[i] = array[j];
                array[j] = swap;
            }
        }
        int t = array[i + 1];
        array[i + 1] = array[r];
        array[r] = t;
        return i + 1;
    }

    @Override
    public String toString(){
        return "QuickSort with Insertion";
    }

    private void insertion(int[] array, int left, int right){
        for(int i=left;i<=right;i++){
            int value = array[i];
            int j = i - 1;
            while (j>=left && array[j] > value){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = value;
        }

    }
}