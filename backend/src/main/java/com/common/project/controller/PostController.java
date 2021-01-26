package com.common.project.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.common.project.dao.PostDao;
import com.common.project.model.member.SignupInputMember;
import com.common.project.model.post.InputPost;
import com.common.project.model.post.Post;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Transactional
@Api(tags = "PostController", description = "게시글 API")
public class PostController {
	@Autowired
	PostDao postDao;
	
	@GetMapping("/notice/search")
	@ApiOperation(value = "검색이나 블로그 검색 할 때 글 리스트가져오기")
	public Object searchPage(@RequestBody SignupInputMember inputMember) {
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@GetMapping("/notice/{pid}")
	@ApiOperation(value = "상세페이지")
	public Object detailPage(@RequestBody SignupInputMember inputMember) {
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@PostMapping("/notice/write")
	@ApiOperation(value = "글쓰기")
	public Object writePage(@RequestBody InputPost inputPost) {
		
		Post post = new Post();
		post.setTitle(inputPost.getTitle());
		post.setEmail(inputPost.getEmail());
		post.setContent(inputPost.getContent());
		post.setLikes(inputPost.getLikes());
		postDao.save(post);
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@DeleteMapping("/notice/delete/{pid}")
	@ApiOperation(value = "글삭제")
	public Object deletePage(@RequestBody SignupInputMember inputMember) {
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@PostMapping("/notice/update")
	@ApiOperation(value = "글 수정")
	public Object updatePage(@RequestBody SignupInputMember inputMember) {
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@PostMapping("/notice/like/{sw}")
	@ApiOperation(value = "좋아요&안좋아요")
	public Object likePage(@RequestBody SignupInputMember inputMember) {
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
//	@GetMapping("/notice/test/{inputURL}")
//	@ApiOperation(value = "크롤링 테스트")
//	public Object lectureList(@RequestBody String inputURL) {
//		
//		try {
//			Document doc = Jsoup.connect(inputURL).get();
//			Elements element = doc.select("div.sect-mo");
//			
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		
//		
//		
//		
//		
//		
//		return new ResponseEntity<>("success", HttpStatus.OK);
//	}
}
