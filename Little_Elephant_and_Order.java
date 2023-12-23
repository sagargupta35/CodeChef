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
            String a = in.nextLine();
            String b = in.nextLine();
            int alf = 0, af = 0, afts = 0, as = 0;
            int blf = 0, bf = 0, bfts = 0, bs = 0;
            Function<Character, Integer> fun = k -> {
                if(k >= '0' && k < '4') return 0;
                if(k == '4') return 1;
                if(k > '4' && k < '7') return 2;
                if(k == '7') return 3;
                return 4;
            };
            for(int i = 0; i<a.length(); i++){
                int j = fun.apply(a.charAt(i));
                switch (j){
                    case 0 -> alf++;
                    case 1 -> af++;
                    case 2 -> afts++;
                    case 3 -> as++;
                }
                j = fun.apply(b.charAt(i));
                switch (j){
                    case 0 -> blf++;
                    case 1 -> bf++;
                    case 2 -> bfts++;
                    case 3 -> bs++;
                }
            }
            StringBuilder sbr = new StringBuilder(a.length());
            if(bs >= afts){
                bs -= afts;
                sbr.append("7".repeat(afts));
                if(bs >= alf){
                    bs -= alf;
                    sbr.append("7".repeat(alf));
                    alf = 0;
                    if(bs >= af){
                        bs -= af;
                        sbr.append("7".repeat(af));
                        if(bs >= as){
                            sbr.append("7".repeat(as));
                            as = 0;
                        } else{
                            sbr.append("7".repeat(bs));
                            as -= bs;
                        }
                        add7(sbr, as, bfts, blf, bf);
                    } else{
                        sbr.append("7".repeat(bs));
                        af -= bs;
                        int [] arr = add7(sbr, as, bfts, blf, bf);
                        blf = arr[1]; bf = arr[2];
                        add4(sbr, bf, blf, af, alf);
                    }
                } else{
                    sbr.append("7".repeat(bs));
                    alf -= bs;
                    int [] arr = add7(sbr, as, bfts, blf, bf);
                    blf = arr[1]; bf = arr[2];
                    add4(sbr, bf, blf, af, alf);
                }
            } else{
                sbr.append("7".repeat(bs));
                int [] arr = add7(sbr, as, bfts, blf, bf);
                blf = arr[1]; bf = arr[2];
                add4(sbr, bf, blf, af, alf);
            }
            out.println(sbr);
        }
        out.close();
	}
	
	public static int [] add7(StringBuilder sbr, int as, int bfts, int blf, int bf){
        if(as == 0) return new int [] {bfts, blf, bf};
        if(as >= bfts){
            sbr.append("7".repeat(bfts));
            as -= bfts;
            bfts = 0;
            if(as >= blf){
                sbr.append("7".repeat(blf));
                as -= blf;
                blf = 0;
                if(as >= bf){
                    sbr.append("7".repeat(bf));
                    bf = 0;
                } else{
                    sbr.append("7".repeat(as));
                    bf -= as;
                }
                return new int [] {bfts, blf, bf};
            } else{
                sbr.append("7".repeat(as));
                blf -= as;
                return new int [] {bfts, blf, bf};
            }
        } else{
            sbr.append("7".repeat(as));
            bfts -= as;
            return new int [] {bfts, blf, bf};
        }
    }

    public static void add4(StringBuilder sbr, int bf, int blf, int af, int alf){
        if(bf >= alf){
            sbr.append("4".repeat(alf));
            bf -= alf;
            if(bf >= af){
                sbr.append("4".repeat(af));
            } else{
                sbr.append("4".repeat(bf));
                af -= bf;
                sbr.append("4".repeat(Math.min(af, blf)));
            }
        } else{
            sbr.append("4".repeat(bf));
            sbr.append("4".repeat(Math.min(af, blf)));
        }
    }
}
