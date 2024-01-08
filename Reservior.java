/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.function.*;

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
        int mod = (int) Math.pow(10, 9) + 7;
        while(t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            String [] arr = new String [n];
            for(int i = 0; i<n; i++) arr[i] = in.nextLine();
            BiFunction<Integer, Integer, Integer> fun1 = (a, b) -> Math.max(0, Math.min(a, b-1));
            BiFunction<String, Integer, Boolean> fun2 = (s, a) ->  s.charAt(a) == 'B';
            Function< Character, Boolean> fun3 = c -> c == 'W' || c == 'B';
            boolean flag = true;
            for(int i = 0; i<n; i++){
                if(flag) {
                    for (int j = 0; j < m; j++) {
                        if (arr[i].charAt(j) == 'W') {
                            if (j == 0 || j == m - 1) {
                                flag = false;
                                break;
                            }
                            char left = arr[i].charAt(j - 1);
                            char right = arr[i].charAt(j + 1);
                            if (!fun3.apply(left) || !fun3.apply(right)) {
                                flag = false;
                                break;
                            }
                            if (i < n - 1) {
                                if (!fun3.apply(arr[i + 1].charAt(j))) {
                                    flag = false;
                                    break;
                                }
                            }
                        } else if (arr[i].charAt(j) == 'B') {
                            if (!fun2.apply(arr[fun1.apply(i + 1, n)], j)) {
                                flag = false;
                                break;
                            }
                        }
                    }
                } else break;
            }
            if(flag) out.println("yes");
            else out.println("no");
        }
        out.close();
	}
}
