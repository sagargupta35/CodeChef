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
            Map<Integer, int []> map = new HashMap<>();
            int [] arr = new int [n];
            for(int i = 0; i<n; i++){
                int k = in.nextInt();
                arr[i] = k;
                map.merge(k, new int [] {1, -1}, (old, newVal) -> {old[0]++; return old;});
            }
            int [] vals;
            int count = 1;
            boolean flag = true;
            for(int i = 0 ;i<n; i++){
                vals = map.get(arr[i]);
                if(vals[1] == -1){
                    if(vals[0] % arr[i] != 0){
                        flag = false;
                        break;
                    }
                    vals[1] = count;
                    vals[0]--;
                    arr[i] = count++;
                } else{
                    if(vals[0] % arr[i] == 0){
                        vals[1] = count;
                        arr[i] = count++;
                    }
                    else{
                        arr[i] = vals[1];
                    }
                    vals[0]--;
                }
            }
            if(flag){
                for(int i : arr) out.print(i + " ");
                out.println("");
            } else out.println(-1);
        }
        out.close();
	}
}
