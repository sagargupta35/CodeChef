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
    
    record Pair(int el, int freq){}
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		FastWriter out = new FastWriter();
        int t = in.nextInt();
        for(int a = 1; a<=t; a++) {
            out.println("Case " + a + ":");
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int [][] heights = new int [n][];
            for(int i = 0; i<n; i++) heights[i] = ai(m);
            Pair [][] maxArr = new Pair [m][n-k+1];
            for(int i = 0; i<m; i++) {
                Pair[] local = maxArr[i];
                int[] maxInCol = findMax(heights, 0, i, k);
                local[0] = new Pair(maxInCol[0], maxInCol[1]);
                int max = local[0].el, freq = local[0].freq;
                for (int j = 1; j <= n - k; j++) {
                    int h = heights[j + k - 1][i];
                    if (h > max) {
                        local[j] = new Pair(h, 1);
                        max = h;
                        freq = 1;
                    } else if (h == max) {
                        local[j] = new Pair(max, heights[j - 1][i] == max ? freq : ++freq);
                    } else {
                        if (heights[j - 1][i] == max) {
                            if (freq == 1) {
                                maxInCol = findMax(heights, j, i, k);
                                max = maxInCol[0];
                                freq = maxInCol[1];
                                local[j] = new Pair(maxInCol[0], maxInCol[1]);
                            } else {
                                local[j] = new Pair(max, --freq);
                            }
                        } else {
                            local[j] = new Pair(max, freq);
                        }
                    }
                }
            }
            for(int i = 0; i<n-k+1; i++){
                int [] maxInLocal = findMax(maxArr, i, 0, k);
                int max = maxInLocal[0], freq = maxInLocal[1];
                out.print(max + (freq > 1 ? "("+freq+")" : "") + " ");
                Pair [] local = maxArr[0];
                for(int j = 1; j<m-k+1; j++){
                    Pair p = maxArr[j+k-1][i];
                    Pair prev = local[i];
                    if(p.el > max){
                        max = p.el;
                        freq = p.freq;
                    } else if(p.el == max){
                        freq += (p.freq-(prev.el == max ? prev.freq : 0));
                    } else{
                        if(prev.el == max){
                            if(prev.freq == freq){
                                maxInLocal = findMax(maxArr, i, j, k);
                                max = maxInLocal[0];
                                freq = maxInLocal[1];
                            } else freq -= prev.freq;
                        }
                    }
                    out.print(max + (freq > 1 ? "("+freq+")" : "") + " ");
                    local = maxArr[j];
                }
                out.println("");
            }
            out.println("");
        }
        out.close();
	}
	
	static int [] findMax(Pair [][] pairs, int row, int col, int k){
        int max = -1, freq = 0;
        for(int i = col; i<col+k; i++){
            if(pairs[i][row].el > max){
                max = pairs[i][row].el;
                freq = pairs[i][row].freq;
            } else if(pairs[i][row].el == max){
                freq += pairs[i][row].freq;
            }
        }
        return new int [] {max, freq};
    }

    static int [] findMax(int [][] arr, int row, int col, int k){
        int max = -1, freq = 0;
        for(int i = row; i<row+k; i++){
            if(arr[i][col] > max){
                max = arr[i][col];
                freq = 1;
            } else if(arr[i][col] == max) freq++;
        }
        return new int [] {max, freq};
    }
}
