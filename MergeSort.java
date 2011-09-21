/**
 * Based on Mergesort from Introduction to Algorithms by Cormen et al.
 */
public class Mergesort implements Sorter {

    public int[] sort(int[] array){
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    /**
     * Recursive merge sort procedure to sort the subarray
     * @param array The array containing the subarray to be sorted.
     * @param p Index of the beginning of the subarray.
     * @param r Index of the end of the subarray.
     */
    private void mergeSort(int[] array, int p, int r){
        if(p < r){
            int q = (p + r) / 2;
            mergeSort(array, p, q);
            mergeSort(array, q + 1, r);
            merge(array, p, q, r);
        }
    }

    /**
     * @param array The array containing the subarrays to be merged.
     * @param p Index of the beginning of the first subarray.
     * @param q Index of the end of the first subarray; the second
     * subarray starts at index q+1.
     * @param r Index of the end of the second subarray.
     */
    private void merge(int[] array, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];

        for(int i = 0; i < n1; i++){
            left[i] = array[p + i];
        }

        for(int j = 0; j < n2; j++){
            right[j] = array[q + j + 1];
        }

        left[n1] = Integer.MAX_VALUE;	// null indicates infinity
        right[n2] = Integer.MAX_VALUE;

        for(int i = 0,  j = 0,  k = p; k <= r; k++){
            if(left[i] <= right[j]){
                array[k] = left[i++];
            }else{
                array[k] = right[j++];
            }
        }
    }

    public String toString(){
        return "Mergesort";
    }
}
