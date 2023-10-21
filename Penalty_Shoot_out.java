/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("").append(String.valueOf(object));
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        FastWriter out = new FastWriter();
        BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null){
            boolean a = false;
            boolean b = false;
            int sa = 0;
            int sb = 0;
            int i = 1;
            while(i <= 10){
                if(s.charAt(i-1) == '1') sa++;
                if(sa > sb + (5-(i/2))){
                    a = true;
                    break;
                }
                if(sb > sa + (4-(i/2))){
                    b = true;
                    break;
                }
                i++;
                if(s.charAt(i-1) == '1') sb++;
                if(sb > sa+(5-(i/2))){
                    b = true;
                    break;
                }
                if(sa > sb+(5-(i/2))){
                    a = true;
                    break;
                }
                i++;
            }
            if(!a && !b){
                while(i <= 20){
                    if(s.charAt(i++-1) == '1') sa++;
                    if(s.charAt(i-1) == '1') sb++;
                    if(sb > sa){
                        b = true;
                        break;
                    } else if(sa > sb){
                        a = true;
                        break;
                    }
                    i++;
                }
            }
            if(a) out.println("TEAM-A " + (i));
            else if(b) out.println("TEAM-B " + (i));
            else out.println("TIE");
        }
        out.close();
	}
}
