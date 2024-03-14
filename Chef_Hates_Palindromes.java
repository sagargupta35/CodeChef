import java.math.BigInteger;
import java.util.*;
import java.io.*;

class CodeChef3 {
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

    static long lcm(long u, long v) {
        return (u / gcd(u, v)) * v;
    }

    static long sumOfNumbers(long start, long end){
        if(end < start) return 0;
        else if(end == start) return end;
        return (((end*(end+1))/2) - ((start*(start-1))/2));
    }

    static class Pair<T, U>{

        T f;
        U s;
        public Pair(T first, U sec){
            this.f = first;
            this.s = sec;
        }
    }
    static BigInteger bigPow(long pow){
        BigInteger res = new BigInteger("1");
        BigInteger bBase = BigInteger.valueOf(2);
        while (pow > 0){
            if(pow%2 == 1){
                res = res.multiply(bBase);
            }
            bBase = bBase.pow(2);
            pow >>= 1;
        }
        return res;
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

    static long pow(long a, long b, long mod){
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

    static boolean isPerfectSquare(long n){
        long k = (long) Math.sqrt(n);
        return (k*k) == n;
    }

    public static List<Integer> findFirstNPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        int num = 2;

        while (primes.size() < n) {
            if (isPrime(num)) {
                primes.add(num);
            }
            num++;
        }

        return primes;
    }

    public static boolean isPrime(int n){
        boolean flag = true;
        for(int i = 2; i<=(int) Math.sqrt(n); i++){
            if(n%i == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }

    record  Triplet<T>(T x, T y, T z){

    }

    static Triplet<Long> extendedEuclid(long a, long b){ // a>b
        if(b == 0){
            return new Triplet<>(a, 0L, a);
        }

        Triplet<Long> smallAns = extendedEuclid(b, a%b);
        long y = smallAns.x - (a/b)*smallAns.y;
        return new Triplet<>(smallAns.y, y, smallAns.z);

    }

    static long modularMultiplicativeInverse(long a, long m){
        long gcd = gcd(a, m);
        if(gcd != 1){
            return -1;
        }
        long x = extendedEuclid(a, m).x;
        x = (x%m + m)%m;
        return x;
    }

    static long modDivide(long a, long b, long m){
        long inv = modularMultiplicativeInverse(b, m);
        if(inv == -1){
            return -1;
        }
        a %= m;
        return (inv * a)%m;
    }

    public static void main(String[] args) throws java.lang.Exception {
        FastWriter out = new FastWriter();
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            if(k == 1){
                out.println(n + " " + "a".repeat(n));
            } else if(k >= n || k > 2){
                char c = 'a';
                StringBuilder main = new StringBuilder();
                for(int i = 0; i<k; i++){
                    main.append(c);
                    c++;
                }
                StringBuilder res = new StringBuilder();
                res.append(main.toString().repeat(n/k));
                n %= k;
                for(int i = 0; i<n; i++){
                    res.append(main.charAt(i));
                }
                out.println(1 + " " + res);
            } else{
                if(n == 1) out.println("1 a");
                else if(n == 2) out.println("1 ab");
                else if(n == 3) out.println("2 aab");
                else if(n == 4) out.println("2 aabb");
                else if(n == 5) out.println("3 aaabb");
                else if(n == 6) out.println("3 aababb");
                else if(n == 7) out.println("3 aaababb");
                else if(n == 8) out.println("3 aaababbb");
                else {
                    int q = n/6;
                    int r = n%6;
                    String s = "aababb";
                    out.print("4 ");
                    for(int i=0;i<q;i++){
                        out.print(s);
                    }
                    for(int i=0;i<r;i++)
                        out.print(s.charAt(i));
                    out.println("");
                }
            }
        }
        out.close();
    }

}