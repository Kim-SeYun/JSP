package dao;

import java.util.List;

import model.MemberVO;

public interface MemberDao {
	// 회원목록
	List<MemberVO> memberList();
	
	// 회원추가
	void addMember(MemberVO vo);
	
	// 회원삭제
	void  delMember(int mno);
	
	// 로그인 인증검사
	boolean isExisted(MemberVO co);

}
