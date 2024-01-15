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

    static FastReader in = new FastReader();

    static int [] ai(int n){
        int [] arr = new int [n];
        for(int i = 0; i<n; i++) arr[i] = in.nextInt();
        return arr;
    }

    static long [] al(int n){
        long [] arr = new long [n];
        for(int i = 0; i<n; i++) arr[i] = in.nextLong();
        return arr;
    }

    static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long fastPower(long a, long b){
        long res = 1;
        while(b > 0){
            if(b%2 == 1){
                res = (res * a%mod)%mod;
            }
            a = (a%mod*a%mod)%mod;
            b >>= 1;
        }
        return res%mod;
    }

    static int mod = (int) Math.pow(10, 9) + 7;
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		FastWriter out = new FastWriter();
		int t = in.nextInt();
		while(t-- > 0){
		    int n = in.nextInt();
            int x = in.nextInt();
            int [] arr = ai(n);
            Map<Integer, Integer> map = new HashMap<>();
            Map<Integer, Integer> xor = new HashMap<>();
            int freq = 0, min = 0;
            for(int i : arr){
                map.merge(i, 1, Integer::sum);
            }
            if(x != 0){
                for(var i : arr){
                    xor.merge(i^x, 1, Integer::sum);
                }
                for(var ent : map.entrySet()){
                    Integer op = xor.get(ent.getKey());
                    if(op != null){
                        if(ent.getValue() + op > freq){
                            freq = ent.getValue() + op;
                            min = op;
                        } else if(ent.getValue() + op == freq){
                            if(min > op){
                                freq = ent.getValue() + op;
                                min = op;
                            }
                        }
                    } else{
                        if(ent.getValue() >= freq){
                            freq = ent.getValue();
                            min = 0;
                        }
                    }
                    xor.remove(ent.getKey());
                }
                for(var ent: xor.entrySet()){
                    if(ent.getValue() > freq){
                        freq = ent.getValue();
                        min = freq;
                    } else if(ent.getValue() == freq) min = Math.min(min, freq);
                }
            } else{
                for(var entry: map.entrySet()){
                    freq = Math.max(freq, entry.getValue());
                }
            }
            out.println(freq + " " + min);
		}
		out.close();
	}
}
