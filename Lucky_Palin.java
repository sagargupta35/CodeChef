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
    
    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    static int mod = (int) Math.pow(10, 9) + 7;
    
    record Pair<T, U>(T f, U s){}

    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		FastWriter out = new FastWriter();
		int t = in.nextInt();
		while(t-- > 0){
		    String str = in.nextLine();
            String str1 = new String(str);
            Pair<String, Integer> pair;
            String lucky = "lucky";
            int minOp = Integer.MAX_VALUE, n = str.length(), n1 = (n-1)/2;
            if(n < 9){
                out.println("unlucky");
                continue;
            }
            for(int i = 0; i+4<=n1; i++){
                pair = minReplacement(str1, lucky, i);
                if(minOp > pair.s || (minOp == pair.s && str.compareTo(pair.f) > 0)){
                    minOp = pair.s;
                    str = pair.f;
                }
            }
            lucky = "ykcul";
            for(int i = 0; i+4<=n1; i++){
                pair = minReplacement(str1, lucky, i);
                if(minOp > pair.s || (minOp == pair.s && str.compareTo(pair.f) > 0)){
                    minOp = pair.s;
                    str = pair.f;
                }
            }
            out.println(str + " " + minOp);
		}
		out.close();
	}
	
	static Pair<String, Integer> minReplacement(String str, String test, int ind){
        StringBuilder sbr = new StringBuilder(str);
        int op = 0, n = str.length(), n2 = n/2;
        for(int i = ind, j = 0; i<ind+5; i++, j++){
            if(sbr.charAt(i) != test.charAt(j)) op++;
            if(i != n-i-1) if(sbr.charAt(n-i-1) != test.charAt(j)) op++;
            sbr.setCharAt(i, test.charAt(j));
            sbr.setCharAt(n-i-1, test.charAt(j));
        }
        for(int i = 0; i<=n2; i++){
            char c = (char) Math.min(sbr.charAt(i), sbr.charAt(n-i-1));
            if(sbr.charAt(i) != c){
                op++;
                sbr.setCharAt(i, c);
            }
            else if (sbr.charAt(n-i-1) != c){
                op++;
                sbr.setCharAt(n-i-1, c);
            }
        }
        return new Pair<>(sbr.toString(), op);
    }
}
