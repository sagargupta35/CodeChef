

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.function.*;

/* Name of the class has to be "Main" only if the class is public. */
class The_Attack_of_Knight
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
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            if(method(x1, x2, 1, 1)){
                if(method(y1, y2, 2, 2)) {
//                    System.out.println("YES");
                    out.println("YES");
                    continue;
                }
            } if(method(x1, x2, 1, 2)){
                if(method(y1, y2, 2, 1)) {
//                    System.out.println("YES");
                    out.println("YES");
                    continue;
                }
            } if(method(x1, x2, 2, 1)){
                if(method(y1, y2, 1, 2)) {
//                    System.out.println("YES");
                    out.println("YES");
                    continue;
                }
            } if(method(x1, x2, 2, 2)){
                if(method(y1, y2, 1, 1)) {
//                    System.out.println("YES");
                    out.println("YES");
                    continue;
                }
            }

//            System.out.println("NO");
            out.println("NO");
        }
        
        out.close();
	}
	
	public static boolean method(int a, int b, int c, int d){
        Predicate<Integer> valid = i -> (i<=8 && i>= 1);
        int k1 = a-c;
        int k2 = a+c;
        int k3 = b-d;
        int k4 = b+d;
        if(valid.test(k1)){
            if(valid.test(k3)) if(k1 == k3) return true;
            if(valid.test(k4)) if(k1 == k4) return true;
        }
        if(valid.test(k2)){
            if(valid.test(k3)) if(k2 == k3) return true;
            if(valid.test(k4)) return k2 == k4;
        }
        return false;
    }
}
