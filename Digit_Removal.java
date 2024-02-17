import java.util.*;
import java.io.*;
import java.util.function.*;
import java.util.regex.Pattern;

class CodeChef{
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

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long pow(long a, long b){
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

    static int aMax(int [] arr){
        int a = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++) a = Math.max(a, arr[i]);
        return a;
    }

    static int aMin(int [] arr){
        int a = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length; i++) a = Math.min(a, arr[i]);
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

    static long sumOfNumbers(long start, long end, int mod){
        if(end < start) return 0;
        else if(end == start) return end;
        return (((end*(end+1))/2) - ((start*(start-1))/2)) %mod;
    }

    static class Pair<T, U>{
        T f;
        U s;
        public Pair(T first, U sec){
            this.f = first;
            this.s = sec;
        }
    }

    public static void main (String[] args) throws java.lang.Exception {
        FastWriter out = new FastWriter();
        int t = in.nextInt();
        while(t-- > 0) {
            Function<Character, Integer> fun = c -> (int)(c-'0');
            StringBuilder s = new StringBuilder(in.next());
            int n = s.length();
            char c = in.next().charAt(0);
            StringBuilder res = new StringBuilder("0".repeat(s.length()));
            int j = -1;
            for(int  i= 0; i<n; i++){
                if(s.charAt(i) == c){
                    if(j == -1) j = i;
                    else res.setCharAt(i, '1');
                }
            }
            if(j == -1){
                out.println(0);
                continue;
            }
            boolean b;
            if(c == '0'){
                b = increaseZero(s, res, j+1, fun);
            } else{
                b = increase(s, res, j+1, fun);
            }
            if(!b) res.setCharAt(j, '1');
            if(c == '9'){
                for(int i = j-1; i>=0; i--){
                    if(s.charAt(i) == '8') res.setCharAt(i, '1');
                    else break;
                }
            }
            out.println(Integer.parseInt(res.toString()));
        }
        out.close();
    }
    
    public static boolean increaseZero(StringBuilder num, StringBuilder res, int st, Function<Character, Integer> fun){
        if(st >= num.length()) return false;
        if(st == num.length()-1){
            if(num.charAt(st) <= '1') return false;
            int cur = fun.apply(num.charAt(st));
            res.setCharAt(st, (char)('0'+11-cur));
            return true;
        }
        int cur = fun.apply(num.charAt(st));
        boolean b = increaseZero(num, res, st+1, fun);
        if(cur == 0){
            res.setCharAt(st, b ? '0' : '1');
            return false;
        } else{
            if(cur == 1){
                if(b) res.setCharAt(st, '9');
                return b;
            }
            if(b){
                res.setCharAt(st, (char)('0' + 10 - cur));
            } else{
                res.setCharAt(st, (char) ('0' + 11 - cur));
            }
            return true;
        }
    }

    public static boolean increase(StringBuilder num, StringBuilder res, int st, Function<Character, Integer> fun){
        if(st >= num.length()) return false;
        if(st == num.length()-1){
            if(num.charAt(st) == '0') return false;
            int cur = fun.apply(num.charAt(st));
            res.setCharAt(st, (char)('0'+10-cur));
            return true;
        }
        int cur = fun.apply(num.charAt(st));
        int f = 10-cur;
        boolean flag = increase(num, res, st+1, fun);
        if(flag){
            res.setCharAt(st, (char)('0'+f-1));
        } else{
            if(num.charAt(st) == '0') return false;
            res.setCharAt(st, (char)('0'+f));
        }
        return true;
    }
}
