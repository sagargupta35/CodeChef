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
          int a = in.nextInt();
          int b = in.nextInt();
          int c = in.nextInt();
          int prev = in.nextInt();
          int factor = 1;
          long res = 0;
          int [] arr = new int [1000001];
          int max = 0;
          for(int i = 0; i<n; i++){
              arr[prev]++;
              max = Math.max(max, prev);
              prev = apply(a, b, c, prev);
          }
          for(int i = 1; i<=max; i++){
              while(arr[i]-- > 0){
                  res += ((long) factor *i);
                  factor *= -1;
              }
          }
          out.println(Math.abs(res));
      }
      out.close();
	}
	
	public static int apply(int a, int b, int c, int prev){
        int mod = 1000000;
        a = ((a * prev)%mod * prev)%mod;
        b *= prev;
        return ((a+b)%mod+c)%mod;
    }
}
