public class QuickSortMedianOfThree implements Sorter {

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
        int i = partition(a, left, medianOf3(a, left, right));
        quicksort(a, left, i - 1);
        quicksort(a, i + 1, right);
    }


    public int partition(int[] array, int p, int r){
	    int x = array[r]; // x is the pivot
	    int i = p - 1;
	    for (int j = p; j < r; j++) {
	      if (array[j] <= x) {
		      i++;
          int swap = array[i];
          array[i] = array[j];
          array[j] = swap;
	      }
	    }
	    int t = array[i+1];
	    array[i+1] = array[r];
	    array[r] = t;
	    return i + 1;
    }

    public int medianOf3(int[] data, int left, int right) {
    int center = (left + right) / 2;
    // order left & center
    if (data[left] > data[center]){
            swap(data, left, center);
        }
    // order left & right
    if (data[left] > data[right]){
            swap(data, left, right);
        }
    // order center & right
    if (data[center] > data[right]){
            swap(data, center, right);
        }

    swap(data, center, right - 1); // put pivot on right
    return right - 1; // return median value
  }

  public void swap(int[] data, int dex1, int dex2) {
    int temp = data[dex1];
    data[dex1] = data[dex2];
    data[dex2] = temp;
  }

    
    
    @Override
    public String toString(){
        return "QuickSort Med 3";
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
