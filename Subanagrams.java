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
        int n = in.nextInt();
        if(n == 1){
            String s = in.nextLine();
            out.println(findCommonLetters(s, s));
        } else{
            String common = findCommonLetters(in.nextLine(), in.nextLine());
            boolean flag = true;
            while(n-- > 2){
                String s = in.nextLine();
                if(common == null){
                    flag = false;
                    break;
                }
                common = findCommonLetters(common, s);
            }
            if(flag && common != null && common.length() != 0) out.println(common);
            else out.println("no such string");
        }
        out.close();
		
	}
	
	public static String findCommonLetters(String s1, String s2){
        if(s1.length() == 0 || s2.length() == 0) return null;
        int [] a1 = new int [26];
        int [] a2 = new int [26];
        for(int i = 0; i<s1.length(); i++){
            a1[s1.charAt(i)-'a']++;
        }
        for(int i = 0; i<s2.length(); i++){
            a2[s2.charAt(i)-'a']++;
        }
        StringBuilder sbr = new StringBuilder();
        for(char i = 'a'; i<='z'; i++){
            sbr.append(Character.toString(i).repeat(Math.min(a1[i-'a'], a2[i-'a'])));
        }
        return sbr.toString();
    }
}
