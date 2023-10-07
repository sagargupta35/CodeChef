/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Good_Binary_Strings
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
            int k1 = 0, k2 = 0;
            // k1 -> 10, k2 -> 01

            long ind = 0;

            for(int i = 0; i<s.length()-1; i++){
                char c = s.charAt(i);
                if(c != s.charAt(i+1)){
                    if(c == '1') k1++;
                    else k2++;
                }
            }

            int t1 = k1, t2 = k2;

            if(s.charAt(0) == s.charAt(1)){
                if(s.charAt(0) == '1') t2++;
                else t1++;
            } else{
                if(s.charAt(0) == '1') t1--;
                else t2--;
            }

            if(t1 == t2) ind++;
            t1= k1; t2 = k2;

            if(s.charAt(s.length()-1) == s.charAt(s.length()-2)){
                if(s.charAt(s.length()-1) == '1') t1++;
                else t2++;
            } else{
                if(s.charAt(s.length()-1) == '1') t2--;
                else t1--;
            }

            if(t1 == t2) ind++;
            t1= k1; t2 = k2;

            for(int i = 1; i<s.length()-1; i++, t1 = k1, t2 = k2){
                char c1 = s.charAt(i-1), c2 = s.charAt(i), c3 = s.charAt(i+1);
                if(c2 == c1){
                    if(c2 == '1') t1++;
                    else t2++;
                } else{
                    if(c2 == '1') t2--;
                    else t1--;
                }
                if(c2 == c3){
                    if(c2 == '1') t2++;
                    else t1++;
                } else{
                    if(c2 == '1') t1--;
                    else t2--;
                }

                if(t1 == t2) ind++;
            }

            out.println(ind);
        }
        out.close();
	}
}
