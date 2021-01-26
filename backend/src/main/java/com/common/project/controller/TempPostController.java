package com.common.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.common.project.model.member.SignupInputMember;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Transactional
@Api(tags = "TempPostController", description = "임시글 API")
public class TempPostController {

	//@Autowired
	
	@PostMapping("/temp/notice/write")
	@ApiOperation(value = "임시 저장하기")
	public Object writeTemp(@RequestBody SignupInputMember inputMember) {
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@GetMapping("/temp/notice/detail/{tid}")
	@ApiOperation(value = "불러오기")
	public Object detailTemp(@RequestBody SignupInputMember inputMember) {
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@PostMapping("/temp/notice/save")
	@ApiOperation(value = "게시글로 저장")
	public Object saveTemp(@RequestBody SignupInputMember inputMember) {
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@DeleteMapping("/temp/notice/delete/{tid}")
	@ApiOperation(value = "임시글 삭제")
	public Object deleteTemp(@RequestBody SignupInputMember inputMember) {
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
}
