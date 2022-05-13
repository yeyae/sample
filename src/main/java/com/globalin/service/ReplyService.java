package com.globalin.service;

import java.util.List;

import com.globalin.domain.Criteria;
import com.globalin.domain.ReplyPage;
import com.globalin.domain.ReplyVO;

//서비스 기능을 하는 @Component
public interface ReplyService {

	public int register(ReplyVO vo);
	
	public ReplyVO get(int rno);
	
	public int modify(ReplyVO vo);
	
	public int remove(int rno);
	
	public List<ReplyVO> getList(Criteria cri, int bno);

	ReplyPage getListPage(Criteria cri, int bno);
}
