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
        int mod = (int) Math.pow(10, 9) + 7;
        while(t-- > 0){
            int n = in.nextInt();
            int m = in.nextInt();
            Graph graph = new Graph(n);
            boolean [] arr = new boolean[n];
            for(int i = 0; i<m; i++){
                int st = in.nextInt();
                int end = in.nextInt();
                graph.addEdge(st-1, end-1);
            }
            long routes = 0, ways = 1;
            for(int i = 0; i<n; i++){
                if(!arr[i]) {
                    int vertices = dfs(graph, arr, i);
                    routes++;
                    ways = (ways * vertices % mod) % mod;
                }
            }
            out.println(routes + " " + ways);
        }
        out.close();
	}
	
	public static int dfs(Graph graph, boolean [] arr, int vertex){
        int res = 1;
        arr[vertex] = true;
        if(graph.connections[vertex] != null) {
            for (int ver : graph.connections[vertex]) {
                if (!arr[ver]) {
                    res += dfs(graph, arr, ver);
                }
            }
        }
        return res;
    }
	
	static class Graph{
        List<Integer> [] connections;
        int vertices;
        public Graph(int vertices){
            this.vertices = vertices;
            connections = new ArrayList [vertices];
        }

        void addEdge(int st, int end){
            if(connections[st] != null) connections[st].add(end);
            else connections[st] = new ArrayList<>(List.of(end));
            if(connections[end] != null) connections[end].add(st);
            else connections[end] = new ArrayList<>(List.of(st));
        }
    }
}
