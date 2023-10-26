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
		    int mg = in.nextInt();
		    int my = in.nextInt();
		    int mr = in.nextInt();
		    int og = in.nextInt();
		    int oy = in.nextInt();
		    int or = in.nextInt();
		    int pg = in.nextInt();
		    int py = in.nextInt();
		    int pr = in.nextInt();
		    
		    long total = 0;
		    
		    long [] leaves = {
		        (long) mg+my+mr, (long) og+oy+or, (long) py+pg+pr,
		        (long) mg+og+pg, (long) my+py+oy, (long) mr+pr+or
		    };
		    
		    for(int i = 0; i<leaves.length; i++){
		        total = 
		            Math.max(total, (leaves[i]&1) == 1 ? leaves[i] : leaves[i]-1);
		    }
		    
		    out.println(total);
		    
		}
		out.close();
	}
}
