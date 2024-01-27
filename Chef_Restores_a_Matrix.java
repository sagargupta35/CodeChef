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
		    int n = in.nextInt();
            int m = in.nextInt();
            int [][] arr = new int [n][];
            for(int i = 0; i<n; i++){
                arr[i] = ai(m);
            }
            //initialise the first element
            if(arr[0][0] == -1) arr[0][0] = 1;

            //initialise first row;
            for(int i = 1; i<m; i++){
                if(arr[0][i] == -1) arr[0][i] = arr[0][i-1];
            }

            //initialise first column
            for(int i = 1; i<n; i++){
                if(arr[i][0] == -1) arr[i][0] = arr[i-1][0];
            }

            for(int i = 1 ; i<n; i++){
                for(int j = 1; j<m; j++){
                    if(arr[i][j] == -1){
                        arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                    }
                }
            }

            boolean flag = true;
            //checking in first row
            for(int i = 1; i<m; i++){
                if(arr[0][i] < arr[0][i-1]){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                out.println(-1);
                continue;
            }
            //checking in first column
            for(int i = 1; i<n; i++){
                if(arr[i][0] < arr[i-1][0]){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                out.println(-1);
                continue;
            }
            for(int i = 1; i<n; i++){
                for(int j = 1; j<m; j++){
                    if(arr[i][j] < Math.max(arr[i-1][j], 
                                                arr[i][j-1])){
                        flag = false;
                        break;
                    }
                }
            }
            if(!flag){
                out.println(-1);
                continue;
            }
            for(int i = 0 ;i<n; i++){
                for(int j = 0; j<m; j++){
                    out.print(arr[i][j] + " ");
                }
                out.println("");
            }
		}
		out.close();
	}
}
