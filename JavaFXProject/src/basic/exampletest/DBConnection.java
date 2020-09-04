package basic.exampletest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	//-----필드---------
	public static Connection dbConn;
    //connection 타입의 dbConn 필드 정의

	
	//-------기본 생성자 ----------
    public static Connection getConnection()//함수, 반환타입은 connection
    {
        Connection conn = null;//커넥션 생성
        

        
        //드라이버 로딩
        try {
        	//2. ------연결 문자열 생성.접속에 필요한 정보로 구성된 문자열, Connection String
            String user = "hr"; 
            String pw = "hr";
            String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클 접속위한 접속 주소
            //1521:포트 / xe : db 아이디 /드라이버 매니저에게 connection객체 요청/ connection 얻기위한 url
            
            
            //------------------------3.jdbc 드라이버 로딩-----------------------------------------
            Class.forName("oracle.jdbc.driver.OracleDriver");//jdbc드라이버 초기화
            System.out.println("드라이버 - 로딩성공");
            //ojdbc받았을때 오라클 패키지 밑에~~ oracleDriver라이브러리 있음(이거사용할꺼)
            //(드라이버 인터페이스 구현한 클래스 로딩)
            
            
            //----------------------------4.접속---------------------------------------------------
            conn = DriverManager.getConnection(url, user, pw);//connection 객체 생성+접속 작업
           System.out.println("Database에 연결되었습니다.\n");
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB 접속(커넥션)실패 : "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        }
        return conn;     
    }

}
