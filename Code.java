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
    
    static int mod = (int) Math.pow(10, 9) + 7;
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here  
		FastReader in = new FastReader();
        FastWriter out = new FastWriter();
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int a = in.nextInt();
            int [] arr = new int [n];
            for(int i = 0; i<n; i++) arr[i] = in.nextInt();
            String op = in.nextLine();
            if(k == 0){
                out.println(a);
                continue;
            }
            int ans = 0;
            switch (op){
                case "XOR" -> {
                    for(int i = 0; i<n; i++){
                        ans ^= arr[i];
                    }
                    ans ^= a;
                    if((k&1) == 1) out.println(ans);
                    else out.println(a);
                }
                case "AND" -> {
                    for(int i = 0; i<n; i++){
                        a &= arr[i];
                    }
                    out.println(a);
                }
                default -> {
                    for(int i = 0; i<n; i++){
                        a |= arr[i];
                    }
                    out.println(a);
                }
            }
        }
        out.close();
		
	}
}
