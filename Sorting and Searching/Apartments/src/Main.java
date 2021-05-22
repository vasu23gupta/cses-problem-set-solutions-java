import java.io.*;
import java.util.*;

public class Main {

    public static void solve(PriorityQueue<Integer> applicants, PriorityQueue<Integer> apartments){
        if(applicants.size()==0 || apartments.size()==0) return;
        int licant = applicants.peek();
        int artment = apartments.peek();
        if(artment-k>licant) {
            //PriorityQueue<Integer> newlicants = new PriorityQueue<>(applicants);
            applicants.poll();
            solve(applicants, apartments);
        }
        else if(artment+k<licant){
            //PriorityQueue<Integer> newartments = new PriorityQueue<>(apartments);
            apartments.poll();
            solve(applicants, apartments);
        }
        else{
            applicants.poll();
            apartments.poll();
            ans++;
            solve(applicants,apartments);
        }
    }
    public static int k;
    public static int ans =0;
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        Reader sc = new Reader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        k = sc.nextInt();
        //sc.nextLine();
        //ArrayList<Integer> a = new ArrayList<>();
        //ArrayList<Integer> b = new ArrayList<>();
        //int[] a = new int[n];
        //int[] b = new int[m];
        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            //a[i]=(sc.nextInt());
            a.add(sc.nextInt());
        }
        //sc.nextLine();
        for (int i = 0; i < m; i++) {
            //b[i]=(sc.nextInt());
            b.add(sc.nextInt());
        }
        //int i=0;
        //int j=0;
        //Arrays.sort(a);
        //Arrays.sort(b);
        //Collections.reverse(apartments);
        //Collections.reverse(applicants);
        //solve(applicants,apartments);
        while(!a.isEmpty() && !b.isEmpty()){
            if(a.peek()<b.peek()-k) a.poll();
            else if(a.peek()>b.peek()+k)b.poll();
            else{
                a.poll();
                b.poll();
                ans++;
            }
        }
        System.out.println(ans);
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
