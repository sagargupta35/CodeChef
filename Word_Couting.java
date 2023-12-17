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

    static int mod = (int) (Math.pow(10, 9) + 7);
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		FastReader in = new FastReader();
        FastWriter out = new FastWriter();
        int [][] ncr = get_ncr(501, 501);
        int t = in.nextInt();
        while(t-- > 0){
            String s = in.nextLine();
            int n = s.length();
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i<n; i++){
                map.merge(s.charAt(i), 1, Integer::sum);
            }
            long ans = 1;
            for(int k : map.values()){
                ans = (ans * ncr[n][k]) % mod;
                n -= k;
            }
            out.println(ans);
        }
        out.close();
	}
	
	static int [][] get_ncr(int a, int b){
        int [][] arr = new int [a][b];
        arr[0][0] = 1;
        arr[1][0] = 1;
        arr[1][1] = 1;
        for(int i = 2; i<a; i++){
            arr[i][0] = 1;
            arr[i][i] = 1;
            for(int j = 1; j<b; j++){
                arr[i][j] = ((arr[i-1][j] + arr[i-1][j-1]) % mod);
            }
        }
        return arr;
    }
}
