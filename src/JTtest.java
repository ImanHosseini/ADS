/**
 * Created by L i o n on 12/14/2016.
 */
import org.jtransforms.dst.*;
public class JTtest {
    private static final double delifreq=5000.0;
    private static int bitperchunk=64;
    private static int byteperchunk=8;
    private static final double freqSTEP=192.0;
    private static final double freqMIN=100.0;

    private static final double freqMAX=freqMIN+freqSTEP*(double)bitperchunk;
    private static final int timeDIV=4;
    private static final double amplitude=0.5;
    public static void main(String[] args){
        int N=StdAudio.SAMPLE_RATE/timeDIV;

        double freq=800.0;
        double freq2=freq(128);
        //System.out.println(N);
        //System.out.println(freq/(double)N);
        double[] data=new double[N];
        for(int i=0;i<N;i++){
            //data[i]=Math.sin(2.0*Math.PI*freq*(double)i/(double)StdAudio.SAMPLE_RATE);
            if(i>0){
                data[i]+=Math.sin(2.0*Math.PI*freq2*(double)i/(double)StdAudio.SAMPLE_RATE);
            }

        }
        DoubleDST_1D ddst=new DoubleDST_1D(N);
        ddst.forward(data,true);
        int j=0;
        double max=0.0;
        for(int i=0;i<N-1;i++){
            if(data[i]>0.8){
                System.out.println(data[i]);
                //System.out.println((double)i/(double)N);
            }
            if(data[i]>max){
                j=i;
                max=data[i];
            }
            //StdDraw.line((double)i/(double)N,data[i],(double)(i+1)/(double)N,data[i+1]);
        }
        System.out.println(j);
    }
    public static double freq(int i){
        return freqMIN+((double)i)*freqSTEP;
    }
}
