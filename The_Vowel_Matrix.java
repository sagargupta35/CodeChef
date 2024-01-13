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
    
    static int mod = (int) Math.pow(10, 9) + 7;
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		FastReader in = new FastReader();
        FastWriter out = new FastWriter();
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.nextLine();
            Function<Character, Boolean> fun = c -> switch (c) {
              case 'a', 'e', 'i', 'o', 'u' -> true;
              default -> false;
            };
            int v = 0, c = 0, i = 0;
            long res = 1;
            while(i < n && v < k) if(fun.apply(s.charAt(i++))) v++;
            v = 0;
            while(i < n){
                if(!fun.apply(s.charAt(i)) && v == 0) c++;
                else if(fun.apply(s.charAt(i))){
                    if(v == 0){
                        res = (res%mod*(c+1))%mod;
                        c = 0;
                    }
                    v = (v+1)%k;
                }
                i++;
            }
            out.println(res);
        }
        out.close();
	}
}
