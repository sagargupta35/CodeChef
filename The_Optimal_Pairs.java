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
        FastWriter out =  new FastWriter();
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int factors = countFactors(n);
            if((n&1) == 1){
                out.println(2*(factors-1));
            } else{
                out.println(2*(factors-1)-1);
            }
        }
        out.close();
	}
	
	public static int countFactors(int n) {
        int count = 1;

        for (int i = 2; i * i <= n; i++) {
            int exponent = 0;
            while (n % i == 0) {
                n /= i;
                exponent++;
            }
            count *= (exponent + 1);
        }

        if (n > 1) {
            count *= 2;
        }

        return count;
    }
}
