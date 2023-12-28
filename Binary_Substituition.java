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
        int modx =  998244353;
        while(t-- > 0){
            String s = in.nextLine();
            StringBuilder sbr = new StringBuilder(s.charAt(0) + "");
            int i = 0, n = s.length();
            char c = s.charAt(0);
            while(i < n && s.charAt(i) == c) i++;
            if(i < n) c = s.charAt(i);
            int count = 0;
            while(i < n){
                if(c == s.charAt(i)) count++;
                else {
                    sbr.append(Character.toString(c)
                    .repeat(Math.min(2, count)));
                    count = 1;
                    c = s.charAt(i);
                }
                i++;
            }
            n = sbr.length();
            if(c != sbr.charAt(n-1)) sbr.append(c);
            int [] arr = new int [n];
            out.println(getWays(sbr.toString(), modx, arr, 0));
        }
        out.close();
	}
	
	public static int getWays(String s, int mod, int [] arr, int x){
        if(s.length()-x <= 2) return s.length()-x;
        if(arr[x] != 0) return arr[x];
        int res;
        if(s.charAt(x) == s.charAt(x+1)){
            arr[x] = getWays(s, mod, arr, x+1);
            return arr[x];
        }
        if(s.charAt(x+1) != s.charAt(x+2)) {
            res = (getWays(s, mod, arr, x + 1) % mod);
            res = (res + getWays(s, mod, arr, x + 2) % mod) % mod;
        } else{
            res = (2 * getWays(s, mod, arr, x+2)%mod)%mod;
        }
        arr[x] = res;
        return res;
    }
}
