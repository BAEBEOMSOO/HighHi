package kr.ac.kopo.exapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExStudent {
	//"1.학생목록  2.학생추가  3.학생삭제  4. 종료" 라고 메뉴를 출력                                            // 학번 스트링, 네임 스트링, 성적만 인트
    // 번호를 입력 받는다.
	// "1"을 입력한 경우, student에 존재하는 모든 학생 목록을 출력
	// "2"을 입력한 경우, 학번, 이름, 성적을 입력받아서, student 테이블에 저장
	// "3"을 입력한 경우, "삭제할 학생의 학번 입력 :"라고 출력하고 , 해당 학생을 테이블에서 삭제
	// "4"를 입력한 경우, 프로그램 종료
	// 위 작업을 무한 반복

	//"5. 성적변경  메뉴를 추가
	// "5"을 입력한 경우, "성적을 변경할 학생의 학번을 입력하세요"라고 출력하고, 학번을 입력받는다. 
	// 입력받은 학번의 학생의 학번, 이름, 성적을 출력한다. //select
	// "변경할 성적을 입력하세요."라고 출력하고, 성적을 입력받는다.
	// 해당 학생의 성적을 입력한 성적으로 테이블에서 변경 // update set
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean i = true;
		
		try { 
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String user = "com"; //
		String password = "com01";
		
		
		while(i) {
		//1
		System.out.println("1.학생목록  2.학생추가  3.학생삭제  4. 종료 5. 성적변경");
		String re = sc.nextLine();
		int input = Integer.parseInt(re);
		
		if(input==1) {
		String sql = "SELECT stu_no, stu_name, stu_score FROM STUDENT";
	      try (
	            Connection conn= DriverManager.getConnection(url, user, password);

	            //명령문 
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            ResultSet rs = pstmt.executeQuery();

	            ) {
	    	  
	         while(rs.next()) {
	            String stu_no = rs.getString("stu_no");
	            String stu_name=rs.getString("stu_name");
	            int stu_score=rs.getInt("stu_score");
	           
	            System.out.println(stu_no+" : "+stu_name+" : "+stu_score);
	         }



	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
		}
	      //2
		else if(input==2) {
	      System.out.println("학번 : ");
			String no = sc.nextLine();
			
			System.out.println("이름 : ");
			String name = sc.nextLine();
			
			System.out.println("성적 : ");
			String se = sc.nextLine();
			
			int pointt = Integer.parseInt(se);
			
			{ 
				//SQL문에서 변화하는 값은 ? 로 표시
			String sql = "INSERT INTO STUDENT \r\n" +"(stu_no, stu_name, stu_score)\r\n" // 컬럼 수정 
			             +"values(?,?,?)"; // 보안을 위해 이렇게 하는게 좋다. 원래는 바로밑에 명령임 // update와 delete도 원하는 값을 넣는곳에 ?를 넣어도 된다.
			            // "VALUES\r\n" +  "('" + id + "', '" + pw + "', '" + name + "', " + point + ")"; // 값 수정 ** 변수넣을때 변수넣고 ctrl+1을 눌러서 put한다

			try ( 
					Connection conn = DriverManager.getConnection(url, user, password); 
					PreparedStatement pstmt = conn.prepareStatement(sql);
			) {  
				// 주입할 값의 타입에 따라서 PreparedStatement 객체의 set타입명() 메서드를 사용
				pstmt.setString(1, no); // pstmp에 들어있는 SQL문의 1번째 ? 에 id 값을 주입
				pstmt.setString(2, name); // pstmp에 들어있는 SQL문의 2번째 ? 에 pw 값을 주입
				pstmt.setInt(3, pointt); // pstmp에 들어있는 SQL문의 4번째 ? 에 point 값을 주입
				int num = pstmt.executeUpdate();
				System.out.println(num + "개의 레코드 추가");
			
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			}
	      }
			
	  //3
		else if(input==3) {
	      System.out.println("삭제할 학생의 학번을 입력하세요.");
	      String no=sc.nextLine();
	      String sql = "DELETE FROM STUDENT WHERE stu_no=?";  // 조건에 맞는 애만 삭제. 5번 출력할떄 참조하기

	      
	      try (Connection conn= DriverManager.getConnection(url, user, password);
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	         ) 
	      {
	         pstmt.setString(1, no); // 첫번째 물음표를 id에 넣어라
	    	  int num =pstmt.executeUpdate();//실행 결과 변경된 레코드 수를 반환
	         System.out.println(num+"개의 레코드 삭제");
	         
	         

	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      }
		
		else if(input==4) {
			System.out.println("프로그램 종료");
			i=false;
		}
		else if(input==5) {
			System.out.println("변경할 학생의 학번을 입력하세요.");
		      String no=sc.nextLine();
		      String sql = "SELECT stu_no, stu_name, stu_score FROM STUDENT WHERE stu_no=" + no;
		      try (
		            Connection conn= DriverManager.getConnection(url, user, password);

		            //명령문 
		            PreparedStatement pstmt = conn.prepareStatement(sql);
		            ResultSet rs = pstmt.executeQuery();

		            ) {
		    	  
		         while(rs.next()) {
		            String stu_no = rs.getString("stu_no");
		            String stu_name=rs.getString("stu_name");
		            int stu_score=rs.getInt("stu_score");
		           
		            System.out.println(stu_no+" : "+stu_name+" : "+stu_score);
		         }



		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      // update set시작
		      System.out.println("변경할 성적을 입력하세요.");
		      String jum=sc.nextLine();
		      String sql2 = "UPDATE STUDENT SET stu_score = ? where stu_no=?";
		      
		      try (Connection conn= DriverManager.getConnection(url, user, password);
			            PreparedStatement pstmt = conn.prepareStatement(sql2);
			         ) 
			      {
			         pstmt.setString(1, jum); // 첫번째 물음표를 id에 넣어라
			         pstmt.setString(2, no); // 첫번째 물음표를 id에 넣어라
			    	  int num =pstmt.executeUpdate();//실행 결과 변경된 레코드 수를 반환
			         System.out.println(num+"개의 레코드 변경");
			         
			         

			      } catch (SQLException e) {
			         e.printStackTrace();
			      }
		      
		      
		      
		      
		      
		      
		      
		      
		      
			      }
		
		
		
		
		
		
		}
	}
	
		}
	
