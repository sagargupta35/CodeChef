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
            StringBuilder bob = new StringBuilder();
            StringBuilder alice = new StringBuilder();
            int a1 = in.nextInt();
            int a2 = in.nextInt();
            int a3 = in.nextInt();
            int sum1 = a1+a2+a3;
            int max1 = Math.max(a1, Math.max(a2, a3));
            int min1 = Math.min(a1, Math.min(a2, a3));
            sum1 -= (max1+min1);
            alice.append(max1).append(sum1).append(min1);

            int b1 = in.nextInt();
            int b2 = in.nextInt();
            int b3 = in.nextInt();

            int max2 = Math.max(b1, Math.max(b2, b3));
            int min2 = Math.min(b1, Math.min(b2, b3));
            int sum3 = (b1+b2+b3) - (max2+min2);
            bob.append(max2).append(sum3).append(min2);
            int j = alice.compareTo(bob);

            if(j > 0){
                out.println("Alice");
            } else if(j < 0){
                out.println("Bob");
            }else{
                out.println("Tie");
            }

        }
        out.close();
	}
}
