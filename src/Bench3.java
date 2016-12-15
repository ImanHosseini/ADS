import java.nio.charset.StandardCharsets;

/**
 * Created by L i o n on 12/14/2016.
 */
public class Bench3 {
    public static void main(String[] args){
        String txt="Salam Mashti! Kheili Mokhlesima! Azinvara! pishe ma nemyai?! bia";
//        for(int i=0;i<2;i++){
//            txt=txt+txt;
//        }
        byte[] dat=txt.getBytes(StandardCharsets.UTF_8);
        FreqTransmitter ft=new FreqTransmitter(dat);
        ft.transmit();
    }
}
