package com.sp.app.bbs;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.common.FileManager;
import com.sp.app.common.dao.CommonDAO;

@Service("bbs.boardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	private CommonDAO dao;
	
	@Autowired
	private FileManager fileManager;
	
	@Override
	public void insertBoard(Board dto, String pathname) throws Exception {
		
		try {
			String saveFilename = fileManager.doFileUpload(dto.getUpload(), pathname);
			if (saveFilename != null) {
				dto.setSaveFilename(saveFilename);
				dto.setOriginalFilename(dto.getUpload().getOriginalFilename());
					// getOriginalFilename()은 MultipartFile 객체의 메소드이다.
			}
					
			dao.insertData("bbs.insertBoard", dto);	// 매퍼에서 "네임스페이스.아이디"			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public List<Board> listBoard(Map<String, Object> map) {
		List<Board> list = null;
		try {
			list = dao.selectList("bbs.listBoard", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int dataCount(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = dao.selectOne("bbs.dataCount", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Board readBoard(int num) {
		Board dto = null;
		
		try {
			dto = dao.selectOne("bbs.readBoard", num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public void updateHitCount(int num) throws Exception {
		try {
			dao.updateData("bbs.updateHitCount", num);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Board preReadBoard(Map<String, Object> map) {
		Board dto = null;
		
		try {
			dto = dao.selectOne("bbs.preReadBoard", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public Board nextReadBoard(Map<String, Object> map) {
		Board dto = null;
		
		try {
			dto = dao.selectOne("bbs.nextReadBoard", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public void updateBoard(Board dto, String pathname) throws Exception {
		try {
			String saveFilename=fileManager.doFileUpload(dto.getUpload(), pathname);
			if (saveFilename!=null) {
				if (dto.getSaveFilename().length()!=0) {
					// 기존 파일 삭제하기
					fileManager.doFileDelete(dto.getSaveFilename(), pathname);
				}
				
				// 새로 업로드 된 파일
				dto.setSaveFilename(saveFilename);
				dto.setOriginalFilename(dto.getUpload().getOriginalFilename());
			}
			
			dao.updateData("bbs.updateBoard", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteBoard(int num, String pathname, String userId) throws Exception {
		try {
			Board dto = readBoard(num);
			if (dto==null || (! userId.equals("admin") && ! dto.getUserId().equals(userId))) {
				return;
			}
			
			if (dto.getSaveFilename()!=null) {
				fileManager.doFileDelete(dto.getSaveFilename(), pathname);
			}
			
			dao.deleteData("bbs.deleteBoard", num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
