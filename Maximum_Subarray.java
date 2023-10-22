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
            int [] a = new int [n];
            long s = 0, l = 0;
            for(int i = 0; i<n; i++) {
                a[i] = in.nextInt();
                l += a[i];
                s = Math.max(s, l);
            }
            int m = in.nextInt();
            int [] b = new int [m];
            long sum = 0;
            for(int i = 0; i<m; i++) {
                b[i] = in.nextInt();
                if(b[i] > 0) sum += b[i];
            }
            long e = 0, r = 0;
            for(int  i= n-1; i>= 0; i--){
                r += a[i];
                e = Math.max(e, r);
            }
            long max = findMax(a);
            out.println(Math.max(0, Math.max(s+sum, Math.max(e+sum, max))));
        }
        out.close();
	}
	public static long findMax(int [] arr){
        long maxSum = Integer.MIN_VALUE;
        long currentSum = 0;

        for (int j : arr) {
            currentSum = Math.max(j, currentSum + j);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
