/**
 * Created by L i o n on 12/14/2016.
 */
public class FreqTransmitter {
    private static final double delifreq=5000.0;
    private static int bitperchunk=8;
    private static int byteperchunk=1;
    private static final double freqSTEP=1536.0;
    private static final double freqMIN=100.0;

    private static final double freqMAX=freqMIN+freqSTEP*(double)bitperchunk;
    private static final int timeDIV=20;
    private static final double amplitude=0.02;
    byte[] data;
    double[] wave;
    int chunks;
    int header=0;
    public FreqTransmitter(byte[] data){
        for(int h=0;h<data.length;h++){
            System.out.println(data[h]);
        }
        this.data=data;
        this.chunks=data.length/byteperchunk;
        //this.header=(int)Math.ceil((double)data.length/512.0);
        this.wave=new double[2*StdAudio.SAMPLE_RATE+chunks*(StdAudio.SAMPLE_RATE/timeDIV)];
    }
    public void transmit(){
        appendHeader();
        for(int j=0;j<chunks;j++){
            boolean[] freqs=new boolean[bitperchunk];
            for(int k=0;k<byteperchunk;k++){
                int num=Byte.toUnsignedInt(data[byteperchunk*j+k]);
                for(int m=0;m<8;m++){
                    if(num%2==0){
                        freqs[8*k+m]=true;
                    }
                    num=num/2;
                }
            }
                for(int h=0;h<bitperchunk;h++){
                    if(freqs[h]){
                        //System.out.println(h);
                        for(int i=0;i<StdAudio.SAMPLE_RATE/timeDIV;i++){
                            wave[(2*StdAudio.SAMPLE_RATE)+(j*StdAudio.SAMPLE_RATE/timeDIV)+i]+=amplitude*Math.sin(2.0*Math.PI*freq(h)*(double)i/(double)StdAudio.SAMPLE_RATE);
                    }
                }
            }
        }
        StdAudio.save("sound.wav",wave);
        System.out.println(chunks);
    }
    public void appendHeader(){
        for(int i=0;i<StdAudio.SAMPLE_RATE;i++){
            wave[i]=0.5*Math.sin(Math.PI*2.0*delifreq*((double)i/(double)StdAudio.SAMPLE_RATE));
        }
    }
    public double freq(int i){
        return freqMIN+((double)i)*freqSTEP;
    }


}
