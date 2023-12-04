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
        while(t-- > 0){
             int n = in.nextInt();
             int m = in.nextInt();

             long sum = (long) n * m;
             int [][] arr = new int [n][m];
             for(int i = 0; i<n; i++){
                 for(int j = 0; j<m; j++){
                     arr[i][j] = in.nextInt();
                 }
             }
             for(int i = 1; i<n-1; i++){
                 for(int j = 1; j<m-1; j++) {
                     int sum1 = 0;
                     int k1 = j - 1, k2 = j + 1, k3 = i - 1, k4 = i + 1;
                     while (k1 >= 0 && k2 < m && arr[i][k1--] == arr[i][k2++] && (k3 >= 0 && k4 < n && arr[k3--][j] == arr[k4++][j]))
                         sum1++;
                     sum += sum1;
                 }
             }
             out.println(sum);
        }
        out.close();
	}
}
