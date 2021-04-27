import sun.nio.ByteBuffered;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;

public class test {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8081);
            OutputStream outputStream = socket.getOutputStream();
//            PrintWriter printWriter=new PrintWriter(outputStream);
//            printWriter.write("$tmb00035ET3318/08/22 11:5804029.94,027.25,20.00,20.00$");
//            printWriter.flush();
            String mgs = "$tmb00035ET3318/08/22 11:5804029.94,027.25,20.00,20.00$";
            outputStream.write(mgs.getBytes());
            InputStream in = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len =0;
            while ((len= in.read(bytes,0,512)) != -1){
                System.out.println(new String(bytes));
            }
//            BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            System.out.println(fromServer.readLine());
            socket.shutdownOutput();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
