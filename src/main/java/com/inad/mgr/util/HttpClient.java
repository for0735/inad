package com.inad.mgr.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class HttpClient {
/*	public static String testHttpRequest(String targetURL, String parameters) {
		  HttpURLConnection connection = null;

		  try {
		    //Create connection
		    URL url = new URL(targetURL);
		    connection = (HttpURLConnection) url.openConnection();
		    // 요청 메소드에 따라서 GET,DELETE, PUT 등으로 변경하시면 됩니다.
		    connection.setRequestMethod("GET"); 
		    //Content-Type 또한 요청 받는 데이터 타입이 Json이면 json타입으로 선언해주시면 되고 
		    // 개발 환경에 따라 설정해주시면 됩니다. 
		    //connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		    // 필요하시다면 넣어주셔도 되고 저의 경우는 필요없는 값이라 제외하였습니다. 
		    //connection.setRequestProperty("Content-Length", Integer.toString(parameters.getBytes().length));
		    // 이 부분 또한 필요하시면 사용해주세요.
		    //connection.setRequestProperty("Content-Language", "en-US");  

		    connection.setUseCaches(false);// 캐싱데이터를 받을지 말지 세팅합니다.
		    connection.setDoOutput(true); // 쓰기모드를 지정할지 세팅합니다.

		    //Send request
		    //위에서 세팅한 정보값을 바탕으로 요청을 보냅니다.
		    DataOutputStream wr = new DataOutputStream (connection.getOutputStream());
		    //파라미터 정보를 보냅니다.
		    wr.writeBytes(parameters);
		    //요청 실행후 dataOutputStream을 close 합니다.
		    wr.close();

		    //Get Response  
		    InputStream is = connection.getInputStream();
		    //요청 결과 (response)를 BufferedReader로 받습니다.
		    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		    // 자바 5 이상은 StringBuffer 를 이용해서 결과 값을 읽습니다.
		    StringBuilder response = new StringBuilder(); 
		    String line;
		    while ((line = rd.readLine()) != null) {
		      response.append(line);
		      response.append('\r');
		    }
		    rd.close();
		    return response.toString();
		  } catch (Exception e) {
		    e.printStackTrace();
		    return null;
		  } finally {
		    if (connection != null) {
		      //에러와 관계없이 모든 로직이 끝나면 connection 객체 (HttpURLConnection)를 
		      // disconnect 하여 모든 연결을 종료합니다. 
		      connection.disconnect();
		    }
		  }
		}*/
	
	public static void getCrt() throws IOException {
    	// 1. URL을 만들기 위한 StringBuilder.
        StringBuilder urlBuilder = new StringBuilder("https://opendart.fss.or.kr/api/corpCode.xml"); /*URL*/
        // 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키.
        urlBuilder.append("?" + URLEncoder.encode("crtfc_key","UTF-8") + "=1b24a7be119ac5ab8df1299727a3d2e282197273"); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*XML 또는 JSON*/
//        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
//        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
//        urlBuilder.append("&" + URLEncoder.encode("cond[country_nm::EQ]","UTF-8") + "=" + URLEncoder.encode("가나", "UTF-8")); /*한글 국가명*/
//        urlBuilder.append("&" + URLEncoder.encode("cond[country_iso_alp2::EQ]","UTF-8") + "=" + URLEncoder.encode("GH", "UTF-8")); /*ISO 2자리코드*/
        // 3. URL 객체 생성.
        URL url = new URL(urlBuilder.toString());
        // 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성.
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 5. 통신을 위한 메소드 SET.
        conn.setRequestMethod("GET");
        // 6. 통신을 위한 Content-type SET. 
        conn.setRequestProperty("Content-type", "application/json");
        // 7. 통신 응답 코드 확인.
        System.out.println("Response code: " + conn.getResponseCode());
        // 8. 전달받은 데이터를 BufferedReader 객체로 저장.
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        // 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장.
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line.toString());
            System.out.println(line.toString());
        }

        // 10. 객체 해제.
        rd.close();
        conn.disconnect();
        // 11. 전달받은 데이터 확인.
        System.out.println(sb.toString());
    }
	
	public static void ttt() throws IOException {
	    try{
	      //String filename = args[0];
	      //String filename = "c:/test.dat";
	      String filename = "C:/Users/admin/Downloads/aaa.txt";
	      FileInputStream File = new FileInputStream(filename);
	      InputStreamReader in = new InputStreamReader(File);
	      
	      int c;
	      String str = new String();
	      while((c=in.read()) != -1){
	       System.out.print(c + " ");
	       str = str + c;
	      }
	      //파일의 내용을 읽어서 화면에 출력한다.(바이트 스트림을 문자 스트림으로 변환한 값을 출력)
	      System.out.println(str);
	      
	      in.close();
	      
	    }catch(IOException ie){
	      System.out.println("파일이 존재하지 않습니다.");
	    }catch(Exception e){
	      System.out.println(e);
	    }
	  }
	
	public static void useByteBuffer() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:/Users/admin/Downloads/aaa.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        ByteBuffer buffer = null;
        FileChannel fc = fis.getChannel();
        int bufferSize = 0;
        try {
            bufferSize = (int)fc.size();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        buffer = ByteBuffer.allocate(bufferSize);
        
        try {
            fc.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        buffer.flip();
//        buffer.order(ByteOrder.LITTLE_ENDIAN);
        try {
            System.out.print(new String(buffer.array() ,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            fc.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/*
	public static void zipBuffer(){
        String destination = "C:/Users/admin/Downloads/aaa.txt";
        String password = "password";
        try {
             //압축파일 생성
             ZipFile zipFile = new ZipFile(destination);
             if (zipFile.isEncrypted()){
                 //비밀번호 해제
                zipFile.setPassword(password);
             }
             //압축 해제
             zipFile.extractAll(destination);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }*/
}
