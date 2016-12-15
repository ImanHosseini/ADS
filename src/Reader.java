import java.nio.charset.StandardCharsets;

/**
 * Created by L i o n on 12/12/2016.
 */
public class Reader {
    private static final int K=8; //Bits per sample (2^K states) *assumed less then 8, mostly {2,4}
    public Reader(){

    }
    public void read(){
        double[] data=StdAudio.read("test_K2.wav");
        byte[] transd=new byte[data.length/(8/K)];
        System.out.println("dlenght: "+data.length);
        for(int i=0;i<transd.length;i++){
           // System.out.println(data[i]);
            int q=0;
            for(int j=0;j<(8/K);j++){
                q+=((int)((data[i*(8/K)+j]+1.0)*(Math.pow(2,K))))*(int)Math.pow(2,8-K*(j+1));
            }
            transd[i]=(byte)(q);
        }
        System.out.print(new String(transd, StandardCharsets.UTF_8));

    }
}
