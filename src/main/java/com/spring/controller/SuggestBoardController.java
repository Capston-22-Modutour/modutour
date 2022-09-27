package com.spring.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.BoardDTO;
import com.spring.dto.Page;
import com.spring.dto.ReplyDTO;
import com.spring.dto.TabDTO;
import com.spring.service.OrderService;
import com.spring.service.ReplyService;
import com.spring.service.SuggestBoardService;
import com.spring.service.TabService;
import com.spring.utils.UploadFileUtils;

@Controller
@RequestMapping("/suggest_board/*")
public class SuggestBoardController {
	
	@Inject
	OrderService service;
	
	@Inject
	SuggestBoardService sbService;
	
	@Inject
	private ReplyService replyService;
	
	@Inject
	TabService tabService;
	
	@Resource(name="uploadPath")
    private String uploadPath;
	
	// 패키지 제안 게시글 목록
	@RequestMapping(value = "/suggest_list", method = RequestMethod.GET)
	public void getSuggestList(Model model) throws Exception {
		
		// Model = Controller와 View 연결해주는 역할
		List<BoardDTO> list = null;
		list = sbService.suggest_list();
		
		model.addAttribute("list", list);
	}

	// 패키지 제안 게시글 작성 get
	@RequestMapping(value = "/suggest_write", method = RequestMethod.GET)
	public void getSuggestWrite(HttpSession session, Model model) throws Exception {
		Object loginInfo = session.getAttribute("member");

		if (loginInfo == null) {
			model.addAttribute("msg", "login_error");
		}
	}

	// 패키지 제안 게시글 작성 post
	@RequestMapping(value = "/suggest_write", method = RequestMethod.POST)
	public String postSuggestWrite(HttpServletRequest request, BoardDTO dto, TabDTO tabDto, MultipartFile file) throws Exception {
		
		// 이미지 업로드
		String imgUploadPath = uploadPath + File.separator + "upload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String file_name = null;
		System.out.println(imgUploadPath);
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 file_name =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
		 file_name = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		dto.setSuggest_img(File.separator + "upload" + ymdPath + File.separator + file_name);
		dto.setSuggest_thumbnail(File.separator + "upload" + ymdPath + File.separator + "s" + File.separator + "s_" + file_name);
		
		//제안 게시글 추가
		sbService.suggest_write(dto);
		
		//suggest_bno변수에 suggest_board 테이블에서 suggest_bno값을 가져와 삽입
		int suggest_bno = tabService.TabInquireSuggestBno();
		tabDto.setSuggest_bno(suggest_bno);
		
		//tab 추가
		tabService.Tabwrite(tabDto);
		
		return "redirect:/suggest_board/suggest_listPageSearch?num=1";
	}

	// 패키지 제안 게시글 조회
	@RequestMapping(value = "/suggest_view", method = RequestMethod.GET)
	public void getSuggestView(@RequestParam("suggest_bno") int suggest_bno, HttpServletRequest request, Model model) throws Exception {
		BoardDTO dto = sbService.suggest_view(suggest_bno);
		
		int board_want_bno = dto.getBoard_want_bno();
		
		// sell_board 테이블 board_want_bno 중복 검색
		int want_boardExist = service.packageCheck(board_want_bno);
		System.out.println("중복 : " + want_boardExist);
		
		// sell_board 테이블 board_want_bno 중복 여부 확인
		if(want_boardExist == 0) { // 중복 X, bid에 0 담아서 model로 전송 => ${bid} 값 == 0
			model.addAttribute("bid", 0);
		} else { // 중복 O, bid에 1 담아서 model로 전송 => ${bid} 값 == 1
			model.addAttribute("bid", 1);
		}
		
		//suggest 게시판 번화와 일치하는 tab 불러오기
		List<TabDTO> list = null;
		list = tabService.Tablist(suggest_bno);
		
		model.addAttribute("view", dto);
		model.addAttribute("list", list);
		
		// 패키지 설계 댓글 조회
		List<ReplyDTO> reply = null; reply = replyService.suggest_list(suggest_bno);
		model.addAttribute("reply", reply);
		 
	}

	// 패키지 제안 게시글 수정
	@RequestMapping(value = "/suggest_modify", method = RequestMethod.GET)
	public void getSuggestModify(@RequestParam("suggest_bno") int suggest_bno, Model model) throws Exception {
		BoardDTO dto = sbService.suggest_view(suggest_bno);

		model.addAttribute("view", dto);
	}

	// 패키지 제안 게시글 수정
	@RequestMapping(value = "/suggest_modify", method = RequestMethod.POST)
	public String postSuggestModify(BoardDTO dto) throws Exception {
		sbService.suggest_modify(dto);

		return "redirect:/suggest_board/suggest_view?suggest_bno=" + dto.getSuggest_bno();
	}

	// 패키지 제안 게시글 삭제
	@RequestMapping(value = "/suggest_delete", method = RequestMethod.GET)
	public String getSuggestDelete(@RequestParam("suggest_bno") int suggest_bno) throws Exception {
		sbService.suggest_delete(suggest_bno);

		return "redirect:/suggest_board/suggest_listPageSearch?num=1";
	}

	// 패키지 제안 게시글 목록 + 페이징 추가 + 검색
	@RequestMapping(value = "/suggest_listPageSearch", method = RequestMethod.GET)
	public void getSuggestListPageSearch(Model model, @RequestParam("num") int num,
			@RequestParam(value = "searchType", required = false, defaultValue = "title") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword)
			throws Exception {

		Page page = new Page();

		page.setNum(num);
		page.setCount(sbService.suggest_searchCount(searchType, keyword));

		// 검색 타입과 검색어
		page.setSearchType(searchType);
		page.setKeyword(keyword);

		List<BoardDTO> want_list = null;
		want_list = sbService.suggest_listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
		
		model.addAttribute("list", want_list);
		model.addAttribute("page", page);
		model.addAttribute("select", num);
	}
	
	//게시물 추천 관련 메소드 get
	@ResponseBody
	@RequestMapping(value = "/suggest_updateLike", method = RequestMethod.GET)
	public void getSuggestUpdateLike() throws Exception {

	}
	
	// 게시물 추천 관련 메소드 post
	@ResponseBody
	@RequestMapping(value = "/suggest_updateLike", method = RequestMethod.POST)
	public int postSuggestUpdateLike(int suggest_bno, int user_num) throws Exception {

		int suggest_likeCheck = sbService.suggest_likeCheck(suggest_bno, user_num);
		if (suggest_likeCheck == 0) {
			// 좋아요 처음누름
			sbService.suggest_insertLike(suggest_bno, user_num); // like테이블 삽입
			sbService.suggest_updateLike(suggest_bno); // 게시판테이블 +1
			sbService.suggest_updateLikeCheck(suggest_bno, user_num);// like테이블 구분자 1
		} else if (suggest_likeCheck == 1) {
			sbService.suggest_updateLikeCheckCancel(suggest_bno, user_num); // like테이블 구분자0
			sbService.suggest_updateLikeCancel(suggest_bno); // 게시판테이블 - 1
			sbService.suggest_deleteLike(suggest_bno, user_num); // like테이블 삭제
		}
		return suggest_likeCheck;
	}
}
