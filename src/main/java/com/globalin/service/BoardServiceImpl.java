package com.globalin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.domain.BoardVO;
import com.globalin.domain.Criteria;
import com.globalin.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;

	private static Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);

	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		log.info("게시물 등록 : " + board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(int bno) {
		// TODO Auto-generated method stub
		log.info("게시글 조회");
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		//sql 실행 결과에 따라서 성공하면 true
		//실패하면 false return을 한다.
		log.info("게시글 수정");
		
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(int bno) {
		log.info("게시글 삭제");
		
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("게시글 전체 조회");
		return mapper.getList();
		
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("게시글 페이지 조회 : " + cri);
		return mapper.getListWithPaging(cri);
		
		
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("전체 게시글 개수 조회");
		return mapper.getTotalCount(cri);
	}

}
