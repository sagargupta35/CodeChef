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
      int n = in.nextInt();
      int m = in.nextInt();
      int [] a = new int [n];
      int [] b = new int [m];
      Map<Integer, Integer> map1 = new HashMap<>();
      Map<Integer, Integer> map2 = new HashMap<>();
      for(int i = 0; i<n; i++){
          a[i] = in.nextInt();
          map1.put(a[i], i);
      }
      for(int i = 0; i<m; i++){
          b[i] = in.nextInt();
          map2.put(b[i], i);
      }
      Arrays.sort(a);
      Arrays.sort(b);
      int b1 = map2.get(b[0]);
      for(int i = 0; i<n; i++) out.println(map1.get(a[i]) + " " + b1);
      b1 = map1.get(a[n-1]);
      for(int i = 1; i<m; i++) out.println(b1 + " " + map2.get(b[i]));
      out.close();
	}
}
