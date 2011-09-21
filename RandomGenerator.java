
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chet
 */
public class RandomGenerator implements Generator{

    public int[] generate(int size) {
        int[] toReturn = new int[size];
        Random rand = new Random();
        for(int i=0;i<size;i++){
            toReturn[i] = rand.nextInt();
        }
        return toReturn;
    }
    
    @Override
    public String toString(){
        return "Uniform Distribution (Random)";
    }
}
