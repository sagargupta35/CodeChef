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
            int n = 12;
            Map<String, int []> map = new HashMap<>();
            while(n-- > 0){
                String [] matchDetails = in.nextLine().split(" ");
                String ht = matchDetails[0];
                int hs = Integer.parseInt(matchDetails[1]);
                String at = matchDetails[4];
                int as = Integer.parseInt(matchDetails[3]);
                map.merge(ht, new int []{hs > as ? 3 : (hs == as ? 1 : 0), hs-as}, (arr, newVal) -> {
                    if(hs > as) arr[0] += 3;
                    else if(hs == as) arr[0] += 1;
                    arr[1] += (hs-as);
                    return arr;
                });
                map.merge(at, new int []{as > hs ? 3 : (hs == as ? 1 : 0), as-hs}, (arr, newVal) -> {
                    if(hs < as) arr[0] += 3;
                    else if(hs == as) arr[0] += 1;
                    arr[1] += (as-hs);
                    return arr;
                });
            }
            String ft = "";
            String st = "";
            int fs = Integer.MIN_VALUE;
            int fg = Integer.MIN_VALUE;
            int ss = Integer.MIN_VALUE;
            int sg = Integer.MIN_VALUE;
            for(var entry: map.entrySet()){
                int [] arr = entry.getValue();
                String key = entry.getKey();
                if(!compare(fs, fg, arr[0], arr[1])){
                    ss = fs;
                    sg = fg;
                    st = ft;
                    fs = arr[0];
                    ft = key;
                    fg = arr[1];
                } else if(!compare(ss, sg, arr[0], arr[1])){
                    ss = arr[0];
                    sg = arr[1];
                    st = key;
                }
            }
            out.println(ft + " " + st);
        }
        out.close();
	}
  public static boolean compare(int fs, int fg, int ss, int sg){
    if(fs > ss) return true;
    return fs == ss && fg > sg;
  }
}
