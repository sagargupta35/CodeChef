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
    
	public static void main (String[] args) throws java.lang.Exception{
		// your code goes here
		   FastReader in = new FastReader();
       FastWriter out = new FastWriter();
    
       int t = in.nextInt();
       while(t-- > 0){
           int n = in.nextInt();
           int m = in.nextInt();
         
           int [] far = new int [n];
           int [] car = new int [m];
         
           for(int i = 0; i<n; i++) far[i] = in.nextInt();
           for(int i = 0; i<m; i++) car[i] = in.nextInt();
         
           int f = 0, c = 0, s = 0;
           boolean flag1 = true, flag2 = true; //true -> football
         
           while(f <n && c < m){
             
               if(car[c] < far[f]){
                   while(c < m && car[c] < far[f]){
                       c++;
                       flag2 = false;
                   }
               } else{
                   while(f < n && far[f] < car[c]){
                       f++;
                       flag2 = true;
                   }
               }
             
               if(flag2 != flag1) {
                   s++;
                   flag1 = flag2;
               }
             
           }
         
           if(f <n || c < m) s++;
           out.println(s);
         
       }
       out.close();
	  }
}
