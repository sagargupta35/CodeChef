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
            int k = in.nextInt();
            if(n== 1){
                out.println("NO");
                continue;
            }
            NavigableSet<Integer> motu = new TreeSet<>();
            NavigableSet<Integer> tomu = new TreeSet<>();
            int j = n - (n&1);
            long msum = 0;
            long tsum  =0;
            for(int i = 0; i<(j/2); i++){
                int k1 = in.nextInt();
                int k2 = in.nextInt();
                msum+=k1;
                tsum+=k2;
                motu.add(k1);
                tomu.add(k2);
            }
            if(n > j) {
                int k1 = in.nextInt();
                msum += k1;
                motu.add(k1);
            }
            while(k-- > 0){
                int min = tomu.first();
                int max = motu.last();
                if(min < max){
                    msum += (min-max);
                    tsum += (max-min);
                    tomu.pollFirst();
                    tomu.add(max);
                    motu.pollLast();
                    motu.add(min);
                } else break;
            }
            if(tsum > msum) out.println("YES");
            else out.println("NO");
        }
        out.close();
	}
}
