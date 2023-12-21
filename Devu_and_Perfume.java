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
            int m = in.nextInt();
            int r_min = Integer.MAX_VALUE;
            int r_max = -1;
            int c_min = Integer.MAX_VALUE;
            int c_max = -1;
            boolean flag = false;
            for(int i = 0; i<n; i++){
                String s = in.nextLine();
                for(int j = 0; j<m; j++){
                    if(s.charAt(j) == '*'){
                        flag = true;
                        r_min = Math.min(r_min, i);
                        r_max = Math.max(r_max, i);
                        c_min = Math.min(c_min, j);
                        c_max = Math.max(c_max, j);
                    }
                }
            }
            if(flag) out.println(Math.max((r_max - r_min +1)/2, (c_max-c_min+1)/2) + 1);
            else out.println(0);
        }
        out.close();
	}
}
