/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chet
 */
public class PreSortGenerator implements Generator{

    public int[] generate(int size) {
        int[] toReturn = new int[size];
        for(int i=0;i<size;i++){
            toReturn[i] = i;
        }
        return toReturn;
    }

    @Override
    public String toString(){
        return "PreSorted";
    }
}
