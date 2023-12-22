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
            String p = in.nextLine();
            long sum = 0;
            int [] arr = new int [26];
            Function<Character, Integer> fun = ch -> switch (ch) {
                case 'a', 'e', 'i', 'o', 'u' -> 0;
                case '?' -> 1;
                default -> 2;
            };
            BiFunction<Character, Character, Integer> biFun = (ch1, ch2) -> {
                if(ch1 == ch2) return 0;
                int a = fun.apply(ch1);
                int b = fun.apply(ch2);
                if(a != 1 && b != 1){
                    if(a==b) return 2;
                    return 1;
                }
                if(a == 1 && b == 1) return 3;
                if(a == 0) return 4;
                if(a == 2) return 5;
                if(b == 0) return 6;
                return 7;
            };
            int c = 0, v = 0;
            for(int i = 0; i<n; i++){
                int j = biFun.apply(s.charAt(i), p.charAt(i));
                switch (j) {
                    case 0, 1, 2 -> sum += j;
                    case 4 -> {
                        arr[s.charAt(i) - 'a']++;
                        v++;
                    }
                    case 5 -> {
                        arr[s.charAt(i) - 'a']++;
                        c++;
                    }
                    case 6 -> {
                        arr[p.charAt(i) - 'a']++;
                        v++;
                    }
                    case 7 -> {
                        arr[p.charAt(i) - 'a']++;
                        c++;
                    }
                }
            }
            int cm = -1, vm = -1;
            for(int i = 0; i<26; i++){
                if(fun.apply((char)(i+97)) == 0) vm = Math.max(vm, arr[i]);
                else cm = Math.max(cm, arr[i]);
            }
            sum += Math.min(v+((c-cm)*2), c + ((v-vm)*2));
            out.println(sum);
        }
        out.close();
	}
}
