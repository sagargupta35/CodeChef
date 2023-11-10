/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
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
	   FastReader in = new FastReader();
       FastWriter out = new FastWriter();
       int t = in.nextInt();
       while(t-- > 0){
           int n = in.nextInt();
           int k = in.nextInt();
           StringBuilder s = new StringBuilder(in.nextLine());
           if(n == 1){
               while(k-- > 0){
                   int q = in.nextInt();
                   out.println(0);
               }
               continue;
           }
           int dis = 0;
            for(int i = 0; i<s.length()-1; i++){
                if(s.charAt(i) != s.charAt(i+1)) dis++;
                else dis+=2;
            }
            for(int i = 0; i<k; i++){
                int q = in.nextInt();
                dis -= getDistance(s, q-1, true);
                dis += getDistance(s, q-1, false);
                out.println(dis);
            }
       }
       out.close();
	}
	
    public static int getDistance(StringBuilder s, 
                int pos, boolean flag){
        int dis = 0;
        if(pos != 0 && pos != s.length()-1){
            if(s.charAt(pos-1) != s.charAt(pos) && flag) dis++;
            else if(s.charAt(pos-1) == s.charAt(pos) && !flag) dis++;
            else dis += 2;
    
            if(s.charAt(pos + 1) != s.charAt(pos) && flag) dis++;
            else if(s.charAt(pos + 1) == s.charAt(pos) && !flag) dis++;
            else dis += 2;
        } else if(pos == 0){
            if(s.charAt(0) != s.charAt(1) && flag) dis++;
            else if(s.charAt(0) == s.charAt(1) && !flag) dis++;
            else dis += 2;
        } else{
            if(s.charAt(s.length()-2) != s.charAt(pos) && flag) dis++;
            else if(s.charAt(s.length()-2) == s.charAt(pos) && !flag) dis++;
            else dis += 2;
        }
        if(!flag){
            if(s.charAt(pos) == '0') s.setCharAt(pos, '1');
            else s.setCharAt(pos, '0');
        }
        return dis;
    }
}
