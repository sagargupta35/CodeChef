import java.util.*;
import java.io.*;
import java.util.function.*;
import java.util.regex.Pattern;

class CodeChef {
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
    static int[] ai(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();
        return arr;
    }

    static long[] al(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextLong();
        return arr;
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                res = (res * a % mod) % mod;
            }
            a = (a % mod * a % mod) % mod;
            b >>= 1;
        }
        return res % mod;
    }

    static int aMax(int[] arr) {
        int a = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) a = Math.max(a, arr[i]);
        return a;
    }

    static int aMin(int[] arr) {
        int a = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) a = Math.min(a, arr[i]);
        return a;
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    static int mod = (int) Math.pow(10, 9) + 7;

    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    static long sumOfNumbers(long start, long end, int mod) {
        if (end < start) return 0;
        else if (end == start) return end;
        return (((end * (end + 1)) / 2) - ((start * (start - 1)) / 2)) % mod;
    }

    static class Pair < T, U > {
        T f;
        U s;
        public Pair(T first, U sec) {
            this.f = first;
            this.s = sec;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        FastWriter out = new FastWriter();
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long [] arr = al(n);
            long max = 0;
            for(int i = 0; i<n; i++){
                max ^= arr[i];
            }
            for(int i = 0; i<n; i++){
                long temp = max^arr[i];
                long cur = arr[i];
                long f = (long)Math.pow(2, Math.floor(Math.log(cur)/Math.log(2)));
                while (cur > 0 && f > 0){
                    if((temp^f) > temp){
                        temp ^= f;
                        cur -= f;
                        f = (long)Math.pow(2, Math.floor(Math.log(cur)/Math.log(2)));
                    } else f /= 2;
                }
                if(cur > 0) temp ^= (cur&1);
                max = Math.max(max, temp);
            }
            System.out.println(max);
        }
        out.close();
    }
}
