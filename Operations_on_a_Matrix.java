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
        while(t-- > 0){
            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();
            int [] row = new int [n];
            int [] col = new int [m];
            long odd = 0;
            while(q-- > 0){
                int r = in.nextInt();
                int c = in.nextInt();
                row[r-1]++;
                col[c-1]++;
            }
            int even_r = 0;
            int even_c = 0;
            for(int  i= 0; i<n; i++){
               if((row[i] & 1) == 0) even_r++;
            }
            for(int  i= 0; i<m; i++){
                if((col[i] & 1) == 0) even_c++;
            }
            odd = ((long) even_r)*(m - even_c) + ((long) even_c)*(n - even_r);
            out.println(odd);
        }
        out.close();
	}
}
