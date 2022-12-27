package conn.service;

import conn.dao.MemberDao;
import conn.domain.MemberVO;
import conn.domain.MemberVO.MemberGrade;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberService {
	
	private MemberDao dao;
	
	// 회원가입
	public void memberJoin(MemberVO vo) {
		dao.insertMember(vo);
	}
	
	// 로그인 체크
	public boolean loginService(MemberVO vo) {
		return dao.loginCheck(vo);
	}
	
	// 회원등급
	public MemberGrade getMemberGrade(String id) {
		return dao.findMemberGradeById(id);
	}
	
	
}