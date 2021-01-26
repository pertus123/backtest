package com.common.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
@Api(tags = "CommentController", description = "댓글 API")
public class CommentController {
	//@Autowired
	
	@PostMapping("/cmt/write")
	@ApiOperation(value = "댓글쓰기")
	public Object writeComment(@RequestBody SignupInputMember inputMember) {
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@GetMapping("/cmt/detail/{pid}")
	@ApiOperation(value = "댓글보기")
	public Object detailComment(@RequestBody SignupInputMember inputMember) {
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@PostMapping("/cmt/update")
	@ApiOperation(value = "댓글수정")
	public Object updateComment(@RequestBody SignupInputMember inputMember) {
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@DeleteMapping("/cmt/delete/{cid}")
	@ApiOperation(value = "댓글삭제")
	public Object deleteComment(@RequestBody SignupInputMember inputMember) {
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
}
