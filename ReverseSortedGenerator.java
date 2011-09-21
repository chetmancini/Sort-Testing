/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chet
 */
public class ReverseSortedGenerator implements Generator{

    public int[] generate(int size) {
        int[] toReturn = new int[size];
        for(int i=size-1;i>=0;i--){
            toReturn[i] = i;
        }
        return toReturn;
    }
    
    public String toString(){
        return "Reverse Sorted";
    }

}
