/**
 * Based on the code from Introduction to Algorithms by Cormen et al.
 */
public class Partitioner {

    /**
     * Partitions a subarray around its last element.
     *
     * @param array The array containing the subarray to be
     * partitioned.
     * @param p Index of the beginning of the subarray.
     * @param r Index of the end of the subarray.
     * @return An index, say <code>q</code>, such that
     * <ul>
     *   <li> <code>array[q]</code> = the original item in
     *   <code>array[r]</code>
     *   <li> <code>array[p..q-1]</code> <= <code>array[q]</code>, and
     *   <li> <code>array[q+1..r]</code> > <code>array[q]</code>.
     * </ul>
     * Works in place.
     */
    public int partition(int[] array, int p, int r){
        int x = array[r]; // x is the pivot
        int i = p - 1;

        // Maintain the invariant
        for(int j = p; j < r; j++){
            if(array[j] <= x){
                i++;
                exchange(array, i, j);
            }
        }

        // Put the pivot value in its correct place and return that
        // index.
        exchange(array, i + 1, r);
        return i + 1;
    }

    /**
     * Exchanges the objects at two positions within an array.
     *
     * @param array 
     * @param i The index of one object.
     * @param j The index of the other object.
     */
    public void exchange(int[] array, int i, int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
