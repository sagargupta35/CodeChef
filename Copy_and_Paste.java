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

    static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long fastPower(long a, long b){
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
		while(t-- > 0){
		    int n = in.nextInt();
            int m = in.nextInt();
            String str = in.nextLine();
            int [] p = new int [n];
            int [] s = new int [n];
            p[0] = str.charAt(0)-'0';
            s[n-1] = str.charAt(n-1) - '0';
            boolean flag = false;
            for(int i = 1; i<n; i++){
                p[i] = p[i-1] + str.charAt(i)-'0';
                if(p[i] > 0) flag = true;
            }
            if(!flag){
                out.println((long)m*n);
                continue;
            }
            for(int i = n-2; i>= 0; i--) s[i] = s[i+1] + str.charAt(i) - '0';
            int sum = 0;
            for(int i = m/2; i<=m/2 + 1; i++){
                for(int j = 0; j<n; j++){
                    if(prefix(p, s, j, i) == suffix(s, p, 
                    j, m-i+1, str)) sum++;
                }
            }
            out.println(sum);
		}
		out.close();
	}
	
	static long prefix(int [] p, int [] s, int ind, int f){
        if(ind == p.length-1) return (long) p[p.length - 1] *f;
        return ((long) p[ind] *f) + ((long) s[ind + 1] *(f-1));
    }

    static long suffix(int [] s, int [] p, int ind, int f, String str){
        if(ind == 0) return (long) s[0] *f - str.charAt(ind) + '0';
        return ((long) s[ind] *f) + ((long) p[ind - 1] *(f-1)) - str.charAt(ind) + '0';
    }
}
