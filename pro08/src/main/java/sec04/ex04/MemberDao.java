package sec04.ex04;

import java.util.List;

public interface MemberDao {
	
	List<MemberVO> memberList();
	void addMember(MemberVO vo);

}