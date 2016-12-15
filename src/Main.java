import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * Created by L i o n on 12/12/2016.
 */
public class Main {
    public static void main(String[] args){
        String txt="Seyed Iman Hosseini Zavaraki\n" +
                "Studying Computer Engineering (Software) and Physics Student at Sharif University\n" +
                "Born:1995\n" +
                "Graduated from Iran’s Atomic Energy High School(2014)\n" +
                "Passed the first level examination of National Astronomy Olympiad(2013)\n" +
                "Passed the first level examination of National Mathematics Olympiad(2012)\n" +
                "Passed the first level examination of National Computer Olympiad(2011, 2013)\n" +
                "Won Gold Medal at the National Physics Olympiad(2013)\n" +
                "Ranked 7th in the selection course for Iran’s team at the IPHO(2014)\n" +
                "Member of the National Elites Foundation(since 2013)\n" +
                "Teaching physics for preparation of Olympiad at top high schools(2013-)\n" +
                "Tutoring linear algebra, calculus, engineering mathematics,… for university students (2014-)\n" +
                "Devised theoretical and experimental questions for the final round of national physics Olympiad(2014 , 2015)\n" +
                "GPA until (including) second semester : 18.76\n" +
                "Member at Digital Media Library, AI division (www.dml.ir) since February 2016\n" +
                "Finished 64th in the world (out of 2500 competing teams) in the IEEEXtreme programming contest (2016)\n" +
                "Programming Languages: fluent in C/C++ and Java, familiar with CUDA, Python, C# \n" +
                "OS: Windows, Linux \n" +
                "Foreign Language: fluent in English\n";
        txt=txt+txt+txt+txt+txt+txt;
        char[] smple=new char[98304];
        for(int i=0;i<smple.length;i++){
            Random r=new Random();
            smple[i]= (char)('a' + r.nextInt(26));
        }
        byte[] data=txt.getBytes(StandardCharsets.UTF_8);
        String str=new String(smple);
        byte[] data2=str.getBytes();
        System.out.println(data.length);
        Transmiter t=new Transmiter(data);
        t.DtoA();
        t.transmit();
    }
}
