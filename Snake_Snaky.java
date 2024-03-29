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
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt()-1;
            int y = in.nextInt()-1;
            int l = in.nextInt();
            String path = in.nextLine();
            Deque<Pair<Integer, Integer>> list = new LinkedList<>();
            list.add(new Pair<>(x, y));
            byte [][] mat = new byte[n][m];
            mat[x][y] = 1;
            for(int i = 0; i<path.length(); i++){
                switch (path.charAt(i)){
                    case 'U' -> y++;
                    case 'R' -> x++;
                    case 'D' -> y--;
                    case 'L' -> x--;
                    default -> {}
                }
                list.add(new Pair<>(x, y));
                mat[x][y] = 1;
            }
            int sum = 0;
            BiFunction<Character, Pair<Integer, Integer>, Pair<Integer, Integer>> fun = (c, p) -> switch (c){
               case 'U' -> new Pair<>(p.f, p.s+1);
               case 'R' -> new Pair<>(p.f+1, p.s);
               case 'L' -> new Pair<>(p.f-1, p.s);
               case 'D' -> new Pair<>(p.f, p.s-1);
               default -> null;

           };

            char c = path.charAt(l-2);
            boolean flag1 = true, flag2 = true;
            while (flag1 && flag2){
                Pair<Integer, Integer> last = list.removeFirst();
                mat[last.f][last.s] = 0;
                Pair<Integer, Integer> head = fun.apply(c, list.peekLast());
                if(head.f < 0 || head.f >= n || head.s < 0 || head.s >= m){
                    flag1 = false;
                    break;
                }
                if(mat[head.f][head.s] == 1){
                    flag2 = false;
                    break;
                }
                list.addLast(head);
                sum++;
            }
            System.out.println((!flag1 ? "WALL " : "BODY ") + sum);
        }
        out.close();
    }
}
