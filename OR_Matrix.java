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
            int [][] arr = new int [n][m];
            boolean flag = false;
            boolean [] row = new boolean[n];
            boolean [] col = new boolean[m];
            for(int i =0; i<n; i++){
                String s = in.nextLine();
                for(int j = 0; j<m; j++){
                    arr[i][j] = s.charAt(j)-'0';
                    if((arr[i][j] & 1) == 1){
                        flag =true;
                        row[i] = true;
                        col[j] = true;
                    }
                }
            }
            if(flag){
                for(int i = 0; i<n; i++){
                    for(int j = 0 ;j<m; j++){
                        if(arr[i][j] == 1) out.print(0 + " ");
                        else if(row[i] || col[j]) out.print(1 + " ");
                        else out.print(2 + " ");
                    }
                    out.println("");
                }
            } else{
                for(int i = 0 ;i<n; i++){
                    for(int j = 0; j<m; j++){
                        out.print(-1 + " ");
                    }
                    out.println("");
                }
            }
        }
        out.close();
	}
}
