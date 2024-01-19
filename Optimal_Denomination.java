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
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		FastWriter out = new FastWriter();
		int t = in.nextInt();
		while(t-- > 0){
		    int n = in.nextInt();
            int [] arr = ai(n);
            if(n == 1){
                out.println(1);
                continue;
            }
            int [] preGcd = new int [n];
            long [] preSum = new long [n];
            int [] sufGcd = new int [n];
            long [] sufSum = new long [n];
            preGcd[0] = arr[0];
            preSum[0] = 1;
            sufGcd[n-1] = arr[n-1];
            sufSum[n-1]  =1;
            //for prefix
            int tempGcd = arr[0];
            for(int i = 1; i<n-1; i++){
                tempGcd = gcd(tempGcd, arr[i]);
                preGcd[i] = tempGcd;
                preSum[i] = preSum[i-1]*(preGcd[i-1]/tempGcd) + (long)arr[i]/tempGcd;
            }
            //for suffix
            tempGcd = arr[n-1];
            sufGcd[n-1] = tempGcd; sufSum[n-1] = 1;
            for(int i = n-2; i>=0; i--){
                tempGcd = gcd(tempGcd, arr[i]);
                sufGcd[i] = tempGcd;
                sufSum[i] = sufSum[i+1]*(sufGcd[i+1]/tempGcd) + (long)arr[i]/tempGcd;
            }
            long minSum = Math.min(sufSum[1], preSum[n-2]) + 1;
            for(int i = 0; i<n-2; i++){
                int temp = gcd(preGcd[i], sufGcd[i+2]);
                long sum = preSum[i]*(preGcd[i]/temp) + sufSum[i+2]*(sufGcd[i+2]/temp) + 1;
                minSum = Math.min(minSum, sum);
            }
            out.println(minSum);
		}
		out.close();
	}
}
