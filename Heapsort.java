
//Came from book, modified by Chet Mancini
/**
 * A wrapper class to perform heapsort.
 */
public class Heapsort implements Sorter {

    int[] array;
    int heapSize;

    public int[] sort(int[] arrayToSort){
        // Since this method is within a class nested within Heap,
        // there must be an existing Heap object that we can use.
        array = arrayToSort;
        heapSize = array.length;

        // build the heap
        for(int i = array.length / 2; i >= 0; i--){
            heapify(i);
        }

        // Do the rest of the heapsort algorithm.
        for(int i = array.length - 1; i >= 1; i--){
            int c = array[0];
            array[0] = array[i];
            array[i] = c;
            heapSize--;
            heapify(0);
        }
        return array;
    }

    public void heapify(int i){
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int smallest = i;
        if(l < heapSize && array[l] > array[i]){
            smallest = l;
        }
        if(r < heapSize && array[r] > array[smallest]){
            smallest = r;
        }
        if(smallest != i){
            int c = array[i];
            array[i] = array[smallest];
            array[smallest] = c;
            heapify(smallest);
        }
    }

    public String toString(){
        return "HeapSort";
    }
}
