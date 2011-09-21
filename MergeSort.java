
/************************************************************************
 *
 * 1. This software is for the purpose of demonstrating one of many
 * ways to implement the algorithms in Introduction to Algorithms,
 * Second edition, by Thomas H. Cormen, Charles E. Leiserson, Ronald
 * L. Rivest, and Clifford Stein.  This software has been tested on a
 * limited set of test cases, but it has not been exhaustively tested.
 * It should not be used for mission-critical applications without
 * further testing.
 *
 * 2. McGraw-Hill licenses and authorizes you to use this software
 * only on a microcomputer located within your own facilities.
 *
 * 3. You will abide by the Copyright Law of the United States.
 *
 * 4. You may prepare a derivative version of this software provided
 * that your source code indicates that it is based on this software and
 * also that you have made changes to it.
 *
 * 5. If you believe that you have found an error in this software,
 * please send email to clrs-java-bugs@mhhe.com.  If you have a
 * suggestion for an improvement, please send email to
 * clrs-java-suggestions@mhhe.com.
 *
 ***********************************************************************/
/**
 * Implements the {@link Sorter} interface via merge sort from
 * pages 29 and 32 of Introduction to Algorithms, Second edition.
 */
public class Mergesort implements Sorter {

    /**
     * Sorts an array of <code>Comparable</code> objects.
     *
     * @param array The array of <code>Comparable</code> objects to be
     * sorted.
     */
    public int[] sort(int[] array){
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    /**
     * Recursive merge sort procedure to sort the subarray
     * <code>array[p..r]</code>.
     *
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
     * Merges two sorted subarrays <code>array[p..q]</code> and
     * <code>array[q+1..r]</code>.  Uses sentinels.
     *
     * @param array The array containing the subarrays to be merged.
     * @param p Index of the beginning of the first subarray.
     * @param q Index of the end of the first subarray; the second
     * subarray starts at index <code>q+1</code>.
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

    /**
     * Compares two objects, returning their relationship.  If an
     * object is given by a <code>null</code> reference, the object's
     * value is assumed to be infinity.
     *
     * @param x One object.
     * @param y The other object.
     * @return A negative integer if <code>x</code> < <code>y</code>;
     * 0 if <code>x</code> equals <code>y</code>; a positive integer
     * if <code>x</code> > <code>y</code>.
     
    private int compare(int x, int y){
        if(x == Integer.MAX_VALUE){
            if(y == Integer.MAX_VALUE){
                return 0;
            } // both x and y are infinity
            else{
                return 1;
            }	   // x is infinity, y is not
        }else if(y == Integer.MAX_VALUE){
            return -1;
        } // y is infinity, x is not
        else{
            if(x<y){
                return -1;
            }else if(x==y){
                return 0;
            }else{
                return 1;
            }
            //return x.compareTo(y);
        } // neither x nor y is infinity
    }
    */
    public String toString(){
        return "Mergesort";
    }
}
