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
            int cs = 0;
            int os = 0;
            while(n-- > 0){
                int k = in.nextInt();
                int a = in.nextInt();
                int b = in.nextInt();
                if(k == 1){
                    cs = a;
                    os = b;
                    out.println("YES");
                } else{
                    int max = Math.max(a, b);
                    int min = a + b - max;
                    if (max == min) {
                        out.println("YES");
                        cs = max;
                        os = min;
                    } else if (min < cs) {
                        out.println("YES");
                        cs = max;
                        os = min;
                    } else if (min < os) {
                        out.println("YES");
                        cs = min;
                        os = max;
                    } else {
                        out.println("NO");
                    }
                }
            }
        }
        out.close();
	}
}
