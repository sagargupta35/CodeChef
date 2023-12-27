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
            int n = in.nextInt(), prev;
            List<Integer> list2 = new ArrayList<>();
             List<Integer> list = new ArrayList<>();
             prev = in.nextInt();
             list2.add(prev);
            for(int i = 1; i<n; i++) {
                int k = in.nextInt();
                if(k < prev) list.add(k);
                else{
                    list2.add(k);
                    prev = k;
                }
            }
            boolean flag = true;
            for(int i = 1; i<list.size(); i++){
                if(list.get(i) < list.get(i-1)){
                    flag = false;
                    break;
                }
            }
            if(flag && list.size() > 0){
                int min = list.get(0), max = list.get(list.size()-1);
                if(max > list2.get(0) && min < list2.get(list2.size()-1)){
                    flag = false;
                    for(int i = 1; i<list2.size(); i++){
                        if(min >= list2.get(i-1) && max <= list2.get(i)){
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if(flag) out.println("YES");
            else out.println("NO");
        }
        out.close();
	}
}
