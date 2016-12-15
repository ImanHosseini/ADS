/**
 * Created by L i o n on 12/14/2016.
 */
import org.jtransforms.dst.*;

import java.nio.charset.StandardCharsets;
import java.util.BitSet;

public class FreqReceiver {
    private static final double delifreq=5000.0;
    private static int bitperchunk=8;
    private static int byteperchunk=1;
    private static final double freqSTEP=1536.0;
    private static final double freqMIN=100.0;

    private static final double freqMAX=freqMIN+freqSTEP*(double)bitperchunk;
    private static final int timeDIV=20;
    private static final double amplitude=0.02;
    public static void main(String[] args){
        double[] data=StdAudio.read("sound.wav");
        int offset=0;
        double fit=0.0;
        int chunksize=64;
        byte[] dataout=new byte[chunksize*byteperchunk];
//        while(true){
//            double datain[]=new double[StdAudio.SAMPLE_RATE];
//            for(int i=0;i<StdAudio.SAMPLE_RATE;i++){
//                datain[i]=data[offset+i];
//            }
//            StdAudio.play(datain);
//
//            DoubleDST_1D ddst=new DoubleDST_1D(StdAudio.SAMPLE_RATE);
//            ddst.forward(datain,true);
//            double newfit=datain[9999];
//            if(newfit<fit && Math.abs(newfit-fit)>10.0){
//               break;
//            }
//            fit=newfit;
//            offset=offset+100;
//            //System.out.println(fit);
//
//        }
//        System.out.println(offset);

        for(int i=0;i<chunksize;i++){
            double datain[]=new double[StdAudio.SAMPLE_RATE/timeDIV];
           for(int j=0;j<StdAudio.SAMPLE_RATE/timeDIV;j++){
               datain[j]=data[offset+j+((StdAudio.SAMPLE_RATE/timeDIV)*i)+(StdAudio.SAMPLE_RATE*2)];
            }

                DoubleDST_1D ddst=new DoubleDST_1D(StdAudio.SAMPLE_RATE/timeDIV);
                ddst.forward(datain,true);


            if(i==0) {
                for (int iin = 0; iin < StdAudio.SAMPLE_RATE / timeDIV - 1; iin++) {
                    if(datain[iin]>0.5)System.out.println(datain[iin]);
                    StdDraw.line((double) iin / (double) (StdAudio.SAMPLE_RATE / timeDIV), datain[iin], (double) (iin + 1) / (double) (StdAudio.SAMPLE_RATE / timeDIV), datain[iin + 1]);
                }
            }
            boolean[] freqs=new boolean[bitperchunk];
            for(int t=0;t<bitperchunk;t++){
                for(int z=0;z<5;z++){
                    if(datain[freqindex(freq(t))+z]>0.3){
                        //System.out.print(t);
                        freqs[t]=true;
                    }
                }

                //System.out.print("\n");
            }
            byte[] bytes=ftob(freqs);
            for(int k=0;k<byteperchunk;k++){
                    dataout[i*byteperchunk+k]=bytes[k];
                //System.out.println(" B "+bytes[k]);
            }
        }
        System.out.println("DONE");
        System.out.println(new String(dataout, StandardCharsets.UTF_8));
        return;
    }
    public static double freq(int i){
        return freqMIN+((double)i)*freqSTEP;
    }
    public static int freqindex(double f){
        return (int)(2.0*f/(double)timeDIV)-3;
    }
    public static byte[] ftob(boolean[] fz){
        byte[] bytes=new byte[byteperchunk];
        for(int i=0;i<byteperchunk;i++){
            int num=0;

            for(int j=0;j<8;j++){
                if(fz[8*i+j]){
                    num+=(int)Math.pow(2,j);
                }
            }
            bytes[i]=(byte) ((-num)-1);
        }
        return bytes;
    }
}
