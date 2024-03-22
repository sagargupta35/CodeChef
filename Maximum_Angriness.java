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
    
    static int [] sieve(int n){
        int [] sieve = new int [n+1];
        sieve[0] = sieve[1] = 1;
        for(int i = 2; i<=n; i++){
            if(sieve[i] == 0){
                sieve[i] = i;
                for(int j = i*2; j<=n; j += i){
                    sieve[j] = i;
                }
            }
        }
        return sieve;
    }

    static Map<Integer, Integer> primeFactorise(int [] sieve, int n){
        Map<Integer, Integer> res = new HashMap<>();
        while (n > 1){
            int j = sieve[n];
            res.merge(j, 1, Integer::sum);
            n /= j;
        }
        return res;
    }

    static long lcmOfArray(int [] arr, int max){
        int [] sieve = sieve(max);
        long ans = 1;
        Map<Integer, Integer> primes = new HashMap<>();
        for (int j : arr) {
            Map<Integer, Integer> cur = primeFactorise(sieve, j);
            for (var entry : cur.entrySet()) {
                primes.merge(entry.getKey(), entry.getValue(), Math::max);
            }
        }
        for(var entry: primes.entrySet()){
            ans = (ans * pow(entry.getKey(), entry.getValue()))%mod;
        }
        return ans;
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
    
    static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    static class Graph{
        int vertices;
        List<Integer> [] edges;
        public Graph(int vertices){
            this.vertices = vertices;
            edges = new ArrayList [vertices];
            Arrays.setAll(edges, i -> new ArrayList<>());
        }

        void addEdge(int st, int end, boolean undirected){
            edges[st].add(end);
            if(undirected) edges[end].add(st);
        }

    }
    
    static int [] fenwickTree(List<Pair<Integer, Integer>> list, int n, int x){
        int [] res = new int [n];
        for(var pair: list){
            int i = pair.f;
            int j = pair.s;
            res[i] += x;
            if(j != n-1) res[j+1] -= x;
        }
        for(int i = 1; i<n; i++){
            res[i] += res[i-1];
        }
        return res;
    }

    public static void main(String[] args) throws java.lang.Exception {
        FastWriter out = new FastWriter();
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextInt();
            long k = in.nextInt();
            if(k >= (n/2)){
                out.println(sumOfNumbers(0L, n-1));
            } else{
                out.println(2*k*n - sumOfNumbers(0L, 2*k));
            }
        }
        out.close();
    }

}
