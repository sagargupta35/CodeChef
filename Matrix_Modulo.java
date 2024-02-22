import java.util.*;
import java.io.*;
import java.util.function.*;
import java.util.regex.Pattern;
import java.math.*;

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

    public static void main (String[] args) throws java.lang.Exception {
        FastWriter out = new FastWriter();
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int [][] arr = new int [n][];
            boolean [] found = new boolean [n*n+1];
            for(int i = 0; i<n; i++) arr[i] = ai(n);
            if(n == 1){
                System.out.println(1);
                continue;
            }
            int max = n*n;
            int large = max/2;
            while (large <= max){
                if(large*2 - (n-1) > max) break;
                large++;
            }
            int dMin = large - (n-1);
            int d = 0;
            boolean can = true;
            for(int i = 0; i<n; i++){
                if((arr[i][i] != 0) &&  (arr[i][i] < dMin || arr[i][i] > large)){
                    can = false;
                    break;
                } else if(found[arr[i][i]]){
                    can = false;
                    break;
                }else if(arr[i][i] != 0) {
                    found[arr[i][i]] = true;
                    d++;
                }
            }
            if(!can){
                System.out.println(0);
                continue;
            }
            int ca = 0, formed = 0;
            for(int i = 1; i<n; i++){
                for(int j = 0; j<i; j++){
                    int f = arr[i][j];
                    int s = arr[j][i];
                    if(f > max || s > max){
                        can = false;
                        break;
                    }
                    if((f >= dMin && f <= large) || (s >= dMin && s <= large)){
                        can = false;
                        break;
                    }
                    if(f == 0 && s == 0){
                        ca++;
                        continue;
                    } else if(f != 0 && s != 0){
                        if(found[s] || found[f]){
                            can = false;
                            break;
                        }
                        if(f%large != s % large){
                            can = false;
                            break;
                        }
                        found[s] = true;
                        found[f] = true;
                        formed++;
                        continue;
                    }
                    f = Math.max(f, s);
                    if(f < large) s = f+large;
                    else s = f%large;
                    if(found[f] || found[s]){
                        can = false;
                        break;
                    }
                    found[f] = true;
                    found[s] = true;
                    formed++;
                }
            }
            if(!can){
                System.out.println(0);
                continue;
            }
            int total = max - large;
            total -= formed;
            long res = ((fac(total, ca)%mod) * fac(n-d)%mod)%mod;
            System.out.println(res);
        }
        out.close();
    }
    
    public static long fac(int n){
        if(n == 0) return 1;
        long res = 1;
        for(int i = n; i>1; i--){
            res = (res%mod*i)%mod;
        }
        return res;
    }
    public static long fac(int total, int last){
        if(total == 0) return 1;
        long res = 1;
        for(int i = total; last > 0; i--, last--){
            res = (res*i)%mod;
            res = (res*2)%mod;
        }
        return res;
    }
}
