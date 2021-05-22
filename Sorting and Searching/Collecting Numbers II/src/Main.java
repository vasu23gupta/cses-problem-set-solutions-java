import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n+1];
        int[] pos = new int[n+1];
        StringBuilder sb = new StringBuilder();
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            pos[x] = i;
            nums[i] = x;
        }
        for (int i = 1; i < n; i++) if (pos[i + 1] < pos[i]) ans++;
        for(int j=0; j<m; j++){
            int a = sc.nextInt();//2
            int b = sc.nextInt();//3
            int n1 = nums[a];//2
            int n2 = nums[b];//1

            if(n1>1){
                if(pos[n1-1]<a && pos[n1-1]>b) ans++;
                if(pos[n1-1]>a && pos[n1-1]<=b) ans--;
            }
            if(n2>1){
                if(pos[n2-1]<b && pos[n2-1]>a) ans++;
                if(pos[n2-1]>b && pos[n2-1]<=a) ans--;
            }
            if(n1<n){
                if(pos[n1+1]<a && pos[n1+1]>b) ans--;
                if(pos[n1+1]>a && pos[n1+1]<=b) ans++;
            }
            if(n2<n){
                if(pos[n2+1]<b && pos[n2+1]>a) ans--;
                if(pos[n2+1]>b && pos[n2+1]<=a) ans++;
            }

            int t = nums[a];
            nums[a] = nums[b];
            nums[b] = t;

            pos[n1] = b;
            pos[n2] = a;

            sb.append(ans+"\n");
        }
        System.out.println(sb);
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
}
