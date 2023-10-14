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
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();
        int t = in.nextInt();
        while(t-- > 0){
            int n = in.nextInt();
            long k = in.nextLong();
            int [] arr = new int [n];
            int [] rev = new int [n];
            for(int i = 0; i<n; i++){
                int j = in.nextInt();
                arr[i] = j;
                rev[n-i-1] = j;
            }

            long i1 = ((k+1)*k)/2;
            long i2 = ((k-1)*k)/2;

            long ans = countInversions(arr)*i1 + (countInversions(rev)*i2);
            out.println(ans);
        }
        out.close();
    }

    public static long countInversions(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    public static long mergeSortAndCount(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            long inversions = mergeSortAndCount(arr, l, m);
            inversions += mergeSortAndCount(arr, m + 1, r);
            inversions += merge(arr, l, m, r);
            return inversions;
        }
        return 0;
    }

    public static long merge(int[] arr, int l, int m, int r) {
        int[] left = new int[m - l + 1];
        int[] right = new int[r - m];
        System.arraycopy(arr, l, left, 0, left.length);
        System.arraycopy(arr, m + 1, right, 0, right.length);

        int i = 0, j = 0, k = l;
        long inversions = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                inversions += left.length - i;
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }

        return inversions;
    }
}
