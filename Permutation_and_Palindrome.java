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
            String s = in.nextLine();
            int n  =s.length();
            Map<Character, ArrayList<Integer>> map = new HashMap<>();
            for(int i = 1; i<=n; i++){
                int finalI = i;
                map.merge(s.charAt(i-1), new ArrayList<>(List.of(i)), (old, newVal) -> {old.add(finalI); return  old;});
            }
            int [] arr = new int [n];
            int left = 0;
            int right = n-1;
            boolean found = false;
            boolean can = true;
            int mid = -1;
            ArrayList<Integer> list;
            for(var e : map.entrySet()){
                list = e.getValue();
                if(list.size() % 2 == 1 && !found){
                    found = true;
                    mid = list.get(list.size()-1);
                } else if(list.size() % 2 == 1){
                    can = false;
                    break;
                }
                for(int i = 0; i<list.size()-1; i+=2){
                    arr[left++] = list.get(i);
                    arr[right--] = list.get(i+1);
                }
            }
            if(mid != -1) arr[n/2] = mid;
            if(can){
                for(int i : arr) out.print(i + " ");
                out.println("");
            } else out.println(-1);
        }
        out.close();
	}
}
