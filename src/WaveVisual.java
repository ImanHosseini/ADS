/**
 * Created by L i o n on 12/14/2016.
 */
public class WaveVisual {
    static String w1="test_K2.wav";
    //static String w2="wave2.wav";
    public static void main(String[] args){
        double[] data1=StdAudio.read(w1);
        //double[] data2=StdAudio.read(w2);
        for(int i=0;i<data1.length-1;i++){
            StdDraw.line((double)(i)/(double)(data1.length),(data1[i]+1.0)/2.0,(double)(i+1)/(double)(data1.length),(data1[i+1]+1.0)/2.0);
        }

    }
}
