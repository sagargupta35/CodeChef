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
        FastWriter out =  new FastWriter();
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            byte [] arr = new byte [n];
            for(int i =0; i<n; i++) arr[i] = (byte) in.nextInt();
            int i = 0, o = 0, z = 0, prev = -1, freq = 1;
            while(i < n){
                if(prev == arr[i]){
                    i++;
                    freq++;
                }
                else{
                    if(prev == 0){
                        z += freq-1;
                    } else o += freq - 1;
                    freq = 1;
                    prev = arr[i++];
                }
            }
            if(prev == 0){
                if(arr[0] == 0) z++;
                z += freq-1;
            }
            else{
                if(arr[0] == 1) o++;
                o += freq-1;
            }
            if(Math.min(o, z) % 2 == 0) out.println("Bob");
            else out.println("Alice");
        }
        out.close();
	}
}
