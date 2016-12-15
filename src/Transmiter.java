/**
 * Created by L i o n on 12/12/2016.
 */
public class Transmiter {
    private final static int K=8;  //bits per sample (2^K states)
    byte[] data;
    double[] adata;
    int[] num;
    public Transmiter(byte[] data){
        this.data=data;
        //adata=new double[data.length*4];
        num=new int[data.length*(8/K)];
    }
    public void DtoA(){
        for(int i=0;i<data.length;i++){
            byte x=data[i];
            int ux=Byte.toUnsignedInt(x);
            for(int j=0;j<(8/K);j++){
                num[(8/K)*i+j]=(ux/(int)Math.pow(2,8-K*(j+1)))%((int)Math.pow(2,K));
            }

        }
    }
    public void transmit(){

        double[] datout=new double[num.length+2*StdAudio.SAMPLE_RATE];
        double freq=220.0;
        for(int j=0;j<StdAudio.SAMPLE_RATE;j++){
            StdAudio.play(0.5*Math.sin(Math.PI*2.0*freq*((double)j/(double)StdAudio.SAMPLE_RATE)));
            datout[j]=0.5*Math.sin(Math.PI*2.0*freq*((double)j/(double)StdAudio.SAMPLE_RATE));
            datout[datout.length-1-j]=0.5*Math.sin(Math.PI*2.0*freq*((double)j/(double)StdAudio.SAMPLE_RATE));
        }
        for(int i=0;i<num.length;i++){
            //StdAudio.play((((double)num[i])/Math.pow(2.0,(double)K)));
            datout[i+StdAudio.SAMPLE_RATE]=(((double)num[i])/Math.pow(2.0,(double)K))-1.0;
            //System.out.println(num[i%adata.length]);
        }
       StdAudio.save("test_K2.wav",datout);

    }
}
