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
        while(t-- > 0){
            int n = in.nextInt();
            int [] bases = new int [33];
            List<int []> list = new ArrayList<>();
            list.add(Arrays.copyOf(bases, 33));
            for(int i = 0; i<n; i++){
                int k = findmsb(in.nextLong());
                bases[k]++;
                list.add(Arrays.copyOf(bases, 33));
            }
            int q = in.nextInt();
            while(q-- > 0){
                int l = in.nextInt();
                int r = in.nextInt();
                int x = findmsb(in.nextLong());
                int sum = r-l+1 - (list.get(r)[x] - list.get(l-1)[x]);
                out.println(sum);
            }
        }
        out.close();
  	}
	
  	static int findmsb(long num){
        int j = 0;
        while(num!=0){
            j++;
            num= num>>1;
        }
        return j;
    }
}
