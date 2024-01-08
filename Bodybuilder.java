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
        int mod = (int) Math.pow(10, 9) + 7;
        while(t-- > 0) {
            int n = in.nextInt();
            int r = in.nextInt();
            int [] a = new int [n];
            int [] b = new int [n];
            for(int i = 0; i<n; i++) a[i] = in.nextInt();
            for(int i = 0; i<n; i++) b[i] = in.nextInt();
            long max = b[0];
            long tens = b[0];
            for(int  i= 1; i<n; i++){
                tens -= (long) (a[i] - a[i - 1]) *r;
                tens = Math.max(tens, 0 );
                tens += b[i];
                max = Math.max(max, tens);
            }
            tens = Math.max(tens, 0 );
            max = Math.max(max, tens);
            out.println(max);
        }

        out.close();
	}
}
