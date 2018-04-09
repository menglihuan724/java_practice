package Thread.Communication;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipeTest {
    public static void main(String[] args) throws IOException {
        PipedWriter out=new PipedWriter();
        PipedReader in=new PipedReader();
        Thread a=new Thread(new Print(in));
        int rec=0;
        out.connect(in);
        a.start();
        while ((rec=System.in.read())!=-1){
            out.write(rec);
        }
    }

    private static class Print implements Runnable {
        PipedReader pipedReader;
        public Print(PipedReader in) {
            pipedReader=in;
        }

        @Override
        public void run() {
            int rec=0;
            try {
                while ((rec=pipedReader.read())!=-1){
                    System.out.println((char)rec);
                }
            } catch (IOException e) {

            }
        }
    }
}