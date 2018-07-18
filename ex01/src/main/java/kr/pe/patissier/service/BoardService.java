package kr.pe.patissier.service;

import java.util.List;
import java.util.Map;

import kr.pe.patissier.domain.BoardVO;
import kr.pe.patissier.domain.Criteria;
import kr.pe.patissier.domain.SearchCriteria;

public interface BoardService {
	public void regist(BoardVO board) throws Exception;
	
	public BoardVO read(int bno) throws Exception;
	
	public void modify(Map map) throws Exception;
	
	public void remove(Map map) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	public int listCountCriteria(Criteria cri) throws Exception;
	
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
}
