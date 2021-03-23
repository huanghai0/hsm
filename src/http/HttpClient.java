package http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    public static void main(String[] args) {
        String response =httpGetConection("http://www.baidu.com");
        System.out.println(response);
    }

    public static String httpGetConection(String URLParam) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(URLParam);    // 把字符串转换为URL请求地址
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(1000 * 6);
            connection.setReadTimeout(1000 * 6);
            connection.setDoInput(true);//允许从服务端读取数据
            connection.connect();// 连接会话
            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {// 循环读取流
                sb.append(line);
            }
            br.close();// 关闭流
            connection.disconnect();// 断开连接
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败!");
        }
//        System.out.println(sb.toString()+"____++++++++++++++++++++++++");
        return sb.toString();
    }
}
