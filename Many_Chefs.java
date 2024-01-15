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

    static FastReader in = new FastReader();

    static int [] ai(int n){
        int [] arr = new int [n];
        for(int i = 0; i<n; i++) arr[i] = in.nextInt();
        return arr;
    }

    static long [] al(int n){
        long [] arr = new long [n];
        for(int i = 0; i<n; i++) arr[i] = in.nextLong();
        return arr;
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long pow(long a, long b){
        long res = 1;
        while(b > 0){
            if(b%2 == 1){
                res = (res * a%mod)%mod;
            }
            a = (a%mod*a%mod)%mod;
            b >>= 1;
        }
        return res%mod;
    }

    static int mod = (int) Math.pow(10, 9) + 7;
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		FastWriter out = new FastWriter();
        int t = in.nextInt();
        Function<Character, Integer> fun = c -> switch (c){
            case 'C' -> 3;
            case 'H' -> 2;
            case 'E' -> 1;
            case 'F' -> 0;
            default -> -1;
        };
        while(t-- > 0) {
            String s = in.nextLine();
		  StringBuilder sb = new StringBuilder(s);
		  int n = s.length();
		  for(int i=n-4;i>=0;i--){
		    if(!(sb.charAt(i)=='C' || sb.charAt(i)=='?')){
		        continue;
		    }
		    if(!(sb.charAt(i+1)=='H' || sb.charAt(i+1)=='?')){
		        continue;
		    }
		    if(!(sb.charAt(i+2)=='E' || sb.charAt(i+2)=='?')){
		        continue;
		    }
		    if(!(sb.charAt(i+3)=='F' || sb.charAt(i+3)=='?')){
		        continue;
		    }
		    
		    sb.setCharAt(i,'C');
		    sb.setCharAt(i+1,'H');
		    sb.setCharAt(i+2,'E');
		    sb.setCharAt(i+3,'F');
		    
		    
		  }
		  for(int j=n-1;j>=0;j--){
		        if(sb.charAt(j)=='?')
		        sb.setCharAt(j,'A');
		    }
		  out.println(sb.toString());
        }
        out.close();
	}
}
