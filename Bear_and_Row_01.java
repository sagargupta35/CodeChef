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

    static class Tuple implements Comparable<Tuple>{
        int num;
        int freq;

        public Tuple(int num, int frq){
            this.num = num;
            this.freq = frq;
        }

        @Override
        public int compareTo(Tuple o1) {
            if(freq != o1.freq) return freq-o1.freq;
            return num-o1.num;
        }

        @Override
        public String toString() {
            return "(" + num + ", " + freq + ")";
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		FastReader in = new FastReader();
        FastWriter out = new FastWriter();
        int t = in.nextInt();
        while(t-- > 0) {
            String s = in.nextLine();
            long sum = 0;
            int i = 0;
            while(i < s.length() && s.charAt(i) == '0') i++;
            int o = 0;
            boolean found = false;
            while(i < s.length()){
                int z = 0;
                if(s.charAt(i) == '1') o++;
                while(i < s.length()-1 && s.charAt(i+1) == '0'){
                    z++;
                    i++;
                    found = true;
                }
                if(found){
                    sum += (long) o * (z+1);
                }
                i++;
                found = false;
            }
            System.out.println(sum);
        }
        out.close();
	}
}
