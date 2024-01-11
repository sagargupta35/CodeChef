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
            int n = in.nextInt();
            int m = in.nextInt();
            int [] a = new int [n];
            int [] b = new int [m];
            for(int i = 0; i<n; i++) a[i] = in.nextInt();
            for(int i = 0; i<m; i++) b[i] = in.nextInt();
            NavigableMap<Integer, Integer> map = new TreeMap<>();
            int last = n-1;
            for(int i = 0; i<m; i++){
                while (last>= n-b[i]){
                    map.merge(a[last], 1, Integer::sum);
                    last--;
                }
            }
            for(int i = 0; i<=last; i++) out.print(a[i] + " ");
            for(var entry: map.entrySet()){
                for(int i = 0; i<entry.getValue(); i++){
                    out.print(entry.getKey() + " ");
                }
            }
            out.println("");
        } 
        out.close();
	}
}
