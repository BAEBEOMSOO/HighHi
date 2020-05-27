package kr.ac.kopo.exapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExJdbc {
	public static void main(String[] args) {
		//오라클 JDBC 드라이버(라이브러리) 클래스인 
		//oracle.jdbc.OracleDriver 클래스를 메모리에 로드
		//INSERT 문
		try { // 여기서 try/catch는 한번만 실행하면 된다.
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";  ////접속할 DB주소 // 주소는 여기다바꾸고
		String user = "com"; // 데이터베이스 계정 아이디   // 아디 패스워드는 여기랑 밑에
		String password = "com01"; // 데이터베이스 계정 비밀번호
		
		{
		String sql = "INSERT INTO MEMBER \r\n" +"(mem_id, mem_pass, mem_name, mem_point)\r\n" // 컬럼 수정 
		             +"VALUES\r\n" +  "('a003', '1234', '고길동', 200)"; // 값 수정
		// try()안에 선언된 변수는 try-catch 블럭 실행이 끝난 후 자동으로 닫아준다.(close)
		try ( 
				// try&catch(예외처리)를 하는 이유는  밑에 pstmt같은 명령문이 오류가 났을때 프로그램이종료되니까 이를 방지하기위해서..
				// 데이터베이스에 접속한 것
				Connection conn = DriverManager.getConnection(url, user, password); //이런애들은 쓰고 닫아줘야함
				// 실행할 SQL문을 명령문 객체로 생성하여 준비
				PreparedStatement pstmt = conn.prepareStatement(sql);// a001이였던 키본키를 a002로 바꿔준다. //이런애들은 쓰고 닫아줘야함
		) {  
			// SQL문을 담은 명령문(객체)를 실행
			// SQL 실행 결과로 데이터를 돌려받는 SQL문(SELECT) executeUpdateQuery()로 실행
			// SQL 실행 결과로 데이터를 돌려받지않는 SQL문(INSERT,UPDATE,DELETE)은  executeUpdate()실행
			int num = pstmt.executeUpdate();  // 실행결과 변경된 레코드 수를 반환 
			System.out.println(num + "개의 레코드 추가");
		
		} catch (SQLException e) { //try에서 오류가 발생하면 catch가 발생하여 타입이 맞으면 catch실행 아니면 종료 
			e.printStackTrace();
		} 
		}
		{
		// select문
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM MEMBER"; // 컬럼 수정 /// 중요!!!~ 값 수정(오라클에서 실행되나 확인하고 commit한후에 여기서도 변경한 후 실행 
		// try()안에 선언된 변수는 try-catch 블럭 실행이 끝난 후 자동으로 닫아준다.(close)
	try ( 
			// try&catch(예외처리)를 하는 이유는  밑에 pstmt같은 명령문이 오류가 났을때 프로그램이종료되니까 이를 방지하기위해서..
			// 데이터베이스에 접속한 것
			Connection conn = DriverManager.getConnection(url, user, password); //이런애들은 쓰고 닫아줘야함
			// 실행할 SQL문을 명령문 객체로 생성하여 준비
			PreparedStatement pstmt = conn.prepareStatement(sql);// sql에서 입력했던 값에서 기본키는 반드시 바꾸어주어야 한다. //이런애들은 쓰고 닫아줘야함
			// SQL문을 담은 명령문(객체)를 실행
			// SQL 실행 결과로 데이터를 돌려받는 SQL문(SELECT) executeUpdateQuery()로 실행
			// SQL 실행 결과로 데이터를 돌려받지않는 SQL문(INSERT,UPDATE,DELETE)은  executeUpdate()실행
			ResultSet rs = pstmt.executeQuery();  // 실행결과 레코드들을 가리키고 있는 ResultSet 반환 , 즉 행을 가리킨다. 하지만 맨처음 ResultSet은 첫 행 이전을 가리키고있는 상태.
	) {  
		
		
		// 처음 ResultSet은 첫 레코드(행) 이전을 가리키는 상태
		while(rs.next()) {  // 괄호안에 re.next를 넣어주는 이유는 rs.next가 boolean타입이기 때문에 다음 값이 없으면 false여서 실행 종료.
		 //  다음과 같이 출력 되도록 프로그램을 변경하세요.
		                                      //맨 처음행이아닌 1행을 가르켜야하기 때문에 이걸 실행한다.
//		a001 : 1234 : 고길동 : 100
//		a002 : 1234 : 마이콜 : 100
//		a003 : 1234 : 도우너 : 100
			
			String memId = rs.getString("mem_id"); // 현재 rs가 가리키는 레코드에서 "mem_id" 컬럼 값 가져오기
			String memPass = rs.getString("mem_pass");
			String memName = rs.getString("mem_name");
			int memPoint = rs.getInt("mem_point");
		System.out.println(memId + ":"+  memPass + ":" +memName + ":" + memPoint);
		}	
	} catch (SQLException e) { //try에서 오류가 발생하면 catch가 발생하여 타입이 맞으면 catch실행 아니면 종료 
		e.printStackTrace();
	} 
		}
		//Q2. a001 회원의 포인트를 777로 변경하는 프로그램을 작성하세요.
	{
		String sql = "UPDATE member SET mem_point = 356 WHERE mem_id = 'a001'"; 
		
		try ( 
				Connection conn = DriverManager.getConnection(url, user, password);
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {  
		
			int num = pstmt.executeUpdate();
			System.out.println(num + "개의 레코드 변경");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		}
	
	
	//Q3. a003 회원을 삭제하는 프로그램을 작성하세요.
	{
		String sql = "DELETE FROM MEMBER WHERE mem_id = 'a003' "; 
		try ( 
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {  
			int num = pstmt.executeUpdate();
			System.out.println(num + "개의 레코드 삭제");
		
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		}


	// Q4. 전체 회원정보를 다시 한번 조회하여  출력하기
	
	{
	String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM MEMBER";
try ( 
		Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(); 
) {  
	
	
	while(rs.next()) {  
		
		String memId = rs.getString("mem_id");
		String memPass = rs.getString("mem_pass");
		String memName = rs.getString("mem_name");
		int memPoint = rs.getInt("mem_point");
	System.out.println(memId + ":"+  memPass + ":" +memName + ":" + memPoint);
	}	
} catch (SQLException e) { 
	e.printStackTrace();
} 
	}
}
}