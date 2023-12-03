/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.function.*;

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
           String s = in.nextLine();
            int n = s.length();
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int q = in.nextInt();
            int l = 0, r = 0, u = 0, d = 0;
            for(int i = 0; i<n; i++){
                switch (s.charAt(i)){
                    case 'L' -> l++;
                    case 'R' -> r++;
                    case 'U' -> u++;
                    case 'D' -> d++;
                }
            }
            while(q-- > 0){
                int x2 = in.nextInt();
                int y2 = in.nextInt();
                int x = x2 - x1;
                int y = y2 - y1;
                if(x > 0 && r >= x) x = 0;
                else if(x < 0 && l >= (x*-1)) x = 0;
                if(y > 0 && u >= y) y = 0;
                else if(y < 0 && d >= (y*-1)) y = 0;
                if(x == 0 && y == 0) out.println("YES " + (Math.abs(x1-x2)+Math.abs(y2-y1)));
                else out.println("NO");
            }
        }
        out.close();
	}
}
