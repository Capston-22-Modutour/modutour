package com.spring.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public String postSuggestWrite(HttpServletRequest request, BoardDTO dto, TabDTO tabDto, 
			MultipartFile file, MultipartHttpServletRequest mtfRequest) throws Exception {
		
		// 단일 이미지 업로드
		/*
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
		*/
		
		String imgUploadPath = uploadPath + File.separator + "upload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		
		System.out.println(imgUploadPath);
		
		List<MultipartFile> fileList = mtfRequest.getFiles("product_detail_image");

        for (MultipartFile mf : fileList) {
            String originFileName = mf.getOriginalFilename(); // 원본 파일 명
            long fileSize = mf.getSize(); // 파일 사이즈

            System.out.println("originFileName : " + originFileName);
            System.out.println("fileSize : " + fileSize);
            
            String blankImage = null;
            String blankImageThum = null;
            
            int suggest_bno = (sbService.suggest_checkBoardBno()+1);
            dto.setDivision_bno(suggest_bno);
            
            if(originFileName == "") {
            	System.out.println("originFileName : 빈칸!!!!");
            	
            	blankImage = uploadPath + File.separator + "images" + File.separator + "none.png";
            	blankImageThum = uploadPath + File.separator + "images" + File.separator + "s_none.png";
            	
            	//이미지 업로드 시 DB에 저장되는 경로
                String dtoBlankImage = File.separator + "images" + File.separator + "none.png";
                String dtoBlankThubmnail = File.separator + "images" + File.separator + "s" + File.separator + "s_none.png";
            	
            	File blankFile = new File(blankImage);
                File blankThumFile = new File(blankImageThum);
            	
            	//dto 세팅
                dto.setImg(dtoBlankImage);
    			dto.setThumbnail(dtoBlankThubmnail);
                
                try {
                	if(mf.isEmpty() ) { // 이미지 업로드 없을시
                		mf.transferTo(new File(blankImage));
                		Files.copy(blankFile.toPath(), blankThumFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } else {
                    	//mf.transferTo(new File(safeFile));	// 실제 경로에 이미지 업로드
                        //Files.copy(orgFile.toPath(), outFile.toPath(), StandardCopyOption.REPLACE_EXISTING);	// 이미지를 복사하여 썸네일 업로드, 이름이 같으면 덮어쓰기
                    }
                } catch (Exception e) {
                	e.printStackTrace();
                }
            } else {
            	//이미지 업로드 시 실제 저장 경로
                String safeFile = imgUploadPath + ymdPath + File.separator + originFileName;
                String safeFileThum = imgUploadPath + ymdPath + File.separator + "s" + File.separator + "s_" + originFileName;
                
                //이미지 업로드 시 DB에 저장되는 경로
                String dtoImageFile = File.separator + "upload" + ymdPath + File.separator + originFileName;
                String dtoThubmnail = File.separator + "upload" + ymdPath + File.separator + "s" + File.separator + "s_" + originFileName;
                
                //이미지 업로드 저장 경로 출력
                System.out.println("파일 이미지 경로 : " + safeFile);
                System.out.println("썸네일 이미지 경로 : " + safeFileThum);
                
                //이미지 업로드 DB 경로 출력
                System.out.println("파일 이미지 DB 경로 : " + dtoImageFile);
                System.out.println("썸네일 이미지 DB 경로 : " + dtoThubmnail);
                
                //파일 저장을 위함
                File orgFile = new File(safeFile);
                File outFile = new File(safeFileThum);
                
                //dto 세팅
                dto.setImg(dtoImageFile);
    			dto.setThumbnail(dtoThubmnail);
                
                try {
                	if(mf.isEmpty() ) { // 이미지 업로드 없을시
                		//mf.transferTo(new File(blankImage));
                		//Files.copy(blankFile.toPath(), blankThumFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } else {
                    	mf.transferTo(new File(safeFile));	// 실제 경로에 이미지 업로드
                        Files.copy(orgFile.toPath(), outFile.toPath(), StandardCopyOption.REPLACE_EXISTING);	// 이미지를 복사하여 썸네일 업로드, 이름이 같으면 덮어쓰기
                    }
                } catch (Exception e) {
                	e.printStackTrace();
                }
            }
			
			sbService.suggest_writeImage(dto);
            
        }
        
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
		List<TabDTO> tabList = null;
		tabList = tabService.Tablist(suggest_bno);
		
		//이미지 조회
		List<BoardDTO> list = null;
		list = sbService.suggest_viewImage(suggest_bno);
		
		model.addAttribute("view", dto);
		model.addAttribute("tabList", tabList);
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
