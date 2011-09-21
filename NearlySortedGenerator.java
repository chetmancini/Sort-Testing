
import java.util.Random;

/**
 * NearlySortedGenerator
 * @author Chet
 */
public class NearlySortedGenerator implements Generator {

    public int[] generate(int size) {
        int[] toReturn = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            toReturn[i] = i;
        }
        
        for(int i=rand.nextInt(5);i<size;i+=50){
            toReturn[i] = Math.abs(rand.nextInt());
        }
        
        return toReturn;
    }
    
    @Override
    public String toString(){
        return "Nearly Sorted";
    }
}
