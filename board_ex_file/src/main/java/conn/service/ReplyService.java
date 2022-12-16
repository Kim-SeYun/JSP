package conn.service;

import java.util.List;

import conn.dao.ReplyDao;
import conn.domain.ReplyVO;

public class ReplyService {
	
	private ReplyDao dao;
	
	public ReplyService(ReplyDao dao) {
		this.dao = dao;
	}

	public List<ReplyVO> list(int bno) {
		return dao.list(bno);
	}
	

}
