package kroryi.loginpage.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyDB {

    private static final String URL = "jdbc:mysql://localhost:3306/member?useSSL=false&useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASS = "1333";

    private static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL, USER, PASS);
    }

    private static List<Member> listMember;

    public MyDB() {
        listMember = new ArrayList<>();
    }

    public static int chkIdPw(String id, String pw) {
        int result = 0;

        for (Member m : listMember) {
            if (m.getId().equals(id)) {
                result += 1;
                if (m.getPw().equals(pw)) {
                    result += 1;
                }
            }
        }
        return result;
    }

    public static void saveMember(Member member) {
        String sql = "INSERT INTO member (name, id, pw, email) VALUES (?,?,?,?)";

        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ){
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getId());
            pstmt.setString(3, member.getPw());
            pstmt.setString(4, member.getEmail());
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }


        listMember.add(member);
    }

    public static List<Member> getListMember() {
        String query = "select * from member";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                listMember.add(new Member(
                        resultSet.getString("name"),
                        resultSet.getString("id"),
                        resultSet.getString("pw"),
                        resultSet.getString("email")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listMember;
    }

    public static void updateMember(Member member) {
        String query = "UPDATE member SET name = ?, id = ?, pw = ?, email = ? WHERE id = ?";

        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)
        ){
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getId());
            pstmt.setString(3, member.getPw());
            pstmt.setString(4, member.getEmail());
            pstmt.setString(5, member.getId());
            pstmt.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

//        for (Member m : listMember) {
//            if (m.getId().equals(member.getId())) {
//                m.setName(member.getName());
//                m.setId(member.getId());
//                m.setPw(member.getPw());
//                m.setEmail(member.getEmail());
//                return;
//            }
//        }
//        System.out.println("회원정보 수정 ID:" + member.getId() + "찾을 수 없음.");
    }

}
