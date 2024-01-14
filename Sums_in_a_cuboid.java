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
        while(t-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            int [][][] b = new int [y][z][x];
            for(int i = 0; i<x; i++){
                for(int j = 0; j<y; j++){
                    for(int k = 0; k<z; k++){
                        b[j][k][i] = in.nextInt();
                    }
                }
            }
            int [][][] a = new int [y][z][x];
            a[0][0][0] = b[0][0][0];
            //1-D
            //X dir
            for(int i = 1; i<x; i++){
                a[0][0][i] = b[0][0][i]-b[0][0][i-1];
            }
            //Z dir
            for(int i = 1; i<z; i++){
                a[0][i][0] = b[0][i][0] - b[0][i-1][0];
            }
            //Y dir
            for(int i = 1; i<y; i++){
                a[i][0][0] = b[i][0][0] - b[i-1][0][0];
            }
            //2 D
            // Z - X plane
            for(int i = 1; i<x; i++){
                for(int j = 1; j<z; j++){
                    a[0][j][i] = b[0][j][i] + b[0][j-1][i-1] - (b[0][j-1][i]+b[0][j][i-1]);
                }
            }
            // Z - Y plane
            for(int i = 1; i<y; i++){
                for(int j = 1; j<z; j++){
                    a[i][j][0] = b[i][j][0] + b[i-1][j-1][0] - (b[i-1][j][0] + b[i][j-1][0]);
                }
            }
            // X - Y plane
            for(int i = 1; i<y; i++){
                for(int j = 1; j<x; j++){
                    a[i][0][j] = b[i][0][j] + b[i-1][0][j-1] - (b[i-1][0][j] + b[i][0][j-1]);
                }
            }
            //3 D
            for(int i = 1; i<y; i++){
                for(int j = 1; j<x; j++){
                    for(int k = 1; k<z; k++){
                        a[i][k][j] = b[i][k][j] - b[i-1][k][j] - b[i][k-1][j] + b[i-1][k-1][j] - b[i][k][j-1] + b[i][k-1][j-1] + b[i-1][k][j-1] - b[i-1][k-1][j-1];
                    }
                }
            }
            for(int i = 0; i<x; i++){
                for(int j = 0; j<y; j++){
                    for(int k = 0; k<z; k++){
                        out.print(a[j][k][i] + " ");
                    }
                    out.println("");
                }
            }
        }
        out.close();
	}
}
