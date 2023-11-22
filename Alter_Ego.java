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
        while(t-- > 0){
            int n = in.nextInt();
            int half = n/2;
            int [] arr = new int [n];
            ArrayList<Integer> even = new ArrayList<>();
            ArrayList<Integer> odd = new ArrayList<>();
            for(int i = 0; i<n; i++){
                arr[i] = in.nextInt();
                if((arr[i] & 1) == 0) even.add(arr[i]);
                else odd.add(arr[i]);
            }
            if((even.size() & 1) != 0){
                out.println(-1);
                continue;
            }
            if(even.size() > 0) even.sort(Comparator.naturalOrder());
            if(odd.size() > 0) odd.sort(Comparator.naturalOrder());
            int [] big = new int [half];
            int [] small = new int [half];
            int c = 0;
            if(even.size() > 0){
                int half1 = even.size()/2;
                for(int i = 0, j = even.size(); i<half1; i++){
                    big[c] = (even.get(i) + even.get(j-i-1))/2;
                    small[c++] = Math.abs(even.get(i) - even.get(j-i-1))/2;
                }
            }
            if(odd.size() > 0){
                int half1 = odd.size()/2;
                for(int i = 0, j = odd.size(); i<half1; i++){
                    big[c] = (odd.get(i) + odd.get(j-i-1))/2;
                    small[c++] = Math.abs(odd.get(i) - odd.get(j-i-1))/2;
                }
            }
            for(int i = 0; i<half; i++){
                out.print(big[i] + " ");
            }
            for(int i = 0; i<half; i++){
                out.print(small[i] + " ");
            }
            out.println("");
        }
        out.close();
	}
}
