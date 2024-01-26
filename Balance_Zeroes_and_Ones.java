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
        while(t-- > 0) {
            int n = in.nextInt();
            StringBuilder s = new StringBuilder(in.nextLine());
            int o = 0, z = 0, k = 0, kz = 0, ko = 0;
            for(int i = 0; i<n; i++){
                if(s.charAt(i) == '0') z++;
                else if(s.charAt(i) == '1') o++;
                else k++;
            }
            if(o > z){
                int j = o-z;
                if(j <= k){
                    kz = j;
                    k -= kz;
                    j = (k/2);
                    k -= j;
                    kz += j;
                    ko = k;
                } else{
                    kz = k;
                }
            } else{
                int j = z-o;
                if(j <= k){
                    ko = j;
                    k -= j;
                    j = (k/2);
                    k -= j;
                    ko += j;
                    kz = k;
                } else{
                    ko = k;
                }
            }
            replace(s, kz, ko);
            out.println(s);
        }
        out.close();
	}
	
	static void replace(StringBuilder sbr, int kz, int ko){
        int i = 0;
        while (kz-- > 0){
            while (i < sbr.length() && sbr.charAt(i) != '?') i++;
            sbr.setCharAt(i, '0');
        }
        while (ko-- > 0){
            while (i < sbr.length() && sbr.charAt(i) != '?') i++;
            sbr.setCharAt(i, '1');
        }
    }
}
