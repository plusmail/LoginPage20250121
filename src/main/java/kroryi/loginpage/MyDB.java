package kroryi.loginpage;

import java.util.ArrayList;
import java.util.List;

public class MyDB {
    private static List<Member> listMember;

    public MyDB() {
        listMember = new ArrayList<>();
        listMember.add(new Member("홍길동","first", "1111", "first@yi.or.kr"));
        listMember.add(new Member("이순신","second", "2222", "second@yi.or.kr"));
        listMember.add(new Member("강감찬","third", "3333", "third@yi.or.kr"));
    }

    public static int chkIdPw(String id, String pw){
        int result = 0;

        for(Member m:listMember){
            if(m.getId().equals(id)){
                result +=1;
                if(m.getPw().equals(pw)){
                    result +=1;
                }
            }
        }
        return result;
    }

    public static void saveMember(Member member){
        listMember.add(member);
    }

    public static List<Member> getListMember() {
        return listMember;
    }
}
