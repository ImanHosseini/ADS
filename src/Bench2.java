/**
 * Created by L i o n on 12/14/2016.
 */
public class Bench2 {
    public static void main(String[] args){
        double freq=5000.0;
        for(int j=0;j<(StdAudio.SAMPLE_RATE);j++){
            StdAudio.play(0.5*Math.sin(Math.PI*2.0*freq*((double)j/(double)StdAudio.SAMPLE_RATE)));
        }
    }
}
