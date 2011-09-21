import java.util.Random;

/**
 * BellCurveGenerator
 * @author Chet
 */
public class BellCurveGenerator implements Generator{
    public int[] generate(int size) {
        int[] toReturn = new int[size];
        Random rand = new Random();
        for(int i=0;i<size;i++){
            toReturn[i] = (int) Math.round(rand.nextGaussian()*1000);
        }
        return toReturn;
    }
    
    @Override
    public String toString(){
        return "Normal Distribution";
    }
}
