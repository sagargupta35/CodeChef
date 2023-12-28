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
            String s = in.nextLine();
            int winPoi = n/2 + 1;
            Function<Character, Character> win = c -> switch (c){
                case 'R' -> 'P';
                case 'S' -> 'R';
                default -> 'S';
            };
            Function<Character, Character> los = c -> switch (c){
                case 'R' -> 'S';
                case 'S' -> 'P';
                default -> 'R';
            };
            StringBuilder sbr = new StringBuilder();
            for(int i = 0; i<n; i++){
                if(n-i-1 < winPoi){
                    sbr.append(win.apply(s.charAt(i)));
                } else{
                    char c1 = s.charAt(i);
                    char c2 = win.apply(c1);
                    char c3 = los.apply(c1);
                    if(c2 < c1 && c2 < c3){
                        sbr.append(c2);
                        winPoi--;
                    }
                    else if(c1 < c2 && c1 < c3){
                        sbr.append(c1);
                    }
                    else{
                        sbr.append(c3);
                    }
                }
            }
            out.println(sbr);
        }
        out.close();
	}
}
