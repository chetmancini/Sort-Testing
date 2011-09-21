/**
 * HoareQuickSort.java
 * @author Chet Mancini
 */
public class HoareQuickSort implements Sorter {

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
        if(right <= left){
            return;
        }
        int i = partition(a, left, right);
        quicksort(a, left, i - 1);
        quicksort(a, i + 1, right);
    }

    public int partition(int[] array, int p, int r){

        int x = array[p]; // x is the pivot
        int i = p - 1;
        int j = r + 1;
        while(true){
            do{
                j--;

            }while(array[j] > x);
            do{
                i++;
            }while(array[i] < x);
            if(i < j){
                int swap = array[i];
                array[i] = array[j];
                array[j] = swap;
            }else{
                return j;
            }

        }
    }

    @Override
    public String toString(){
        return "Hoare QuickSort";
    }
}
