package com.common.project.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.common.project.dao.MemberDao;
import com.common.project.model.member.SignupInputMember;
import com.common.project.model.member.InfoInputMember;
import com.common.project.model.member.LoginInputMember;
import com.common.project.model.member.Member;
import com.common.project.service.JwtService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Transactional
@Api(tags = "MemberController", description = "회원 API")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class MemberController {
	
	@Autowired
	private JwtService jwtService;
	@Autowired
	MemberDao memberDao;
	
	//토큰도 생성.ㅇㅋ
	@PostMapping("/user/login")
	@ApiOperation(value = "로그인", notes="성공시 jwt 토큰을 반환합니다.")
	public Object login(@RequestBody LoginInputMember inputMember) {
		String originalPassword = inputMember.getPassword();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(inputMember.getPassword().getBytes());
			inputMember.setPassword(String.format("%040x", new BigInteger(1, md.digest())));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		Optional<Member> memberOpt = memberDao.findMemberByEmailAndPassword(inputMember.getEmail(), inputMember.getPassword());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(memberOpt.isPresent()) { // 값이 존재하면, 
			Member memberInfo = memberDao.getMemberByEmail(inputMember.getEmail());
			memberInfo.setPassword(originalPassword);
			resultMap.put("auth-token", jwtService.create(memberInfo));
			return new ResponseEntity<>(resultMap, HttpStatus.OK);
		}
		else return new ResponseEntity<>(resultMap, HttpStatus.NOT_FOUND);
	}
	
	//ㅇㅋ
	@PostMapping("/user/signup")
	@ApiOperation(value = "가입하기")
	public Object signup(@RequestBody SignupInputMember inputMember) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(inputMember.getPassword().getBytes());
			inputMember.setPassword(String.format("%040x", new BigInteger(1, md.digest())));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		Member member = new Member(inputMember.getEmail(),inputMember.getPassword(), inputMember.getName());
		Optional<Member> memberOpt = memberDao.findMemberByEmail(inputMember.getEmail());
		
		if(!memberOpt.isPresent()) { // 이메일이 존재하지  않으면 -> 중복 X
			memberDao.save(member);
			return new ResponseEntity<>("success", HttpStatus.OK);
		}
		else return new ResponseEntity<>("duplication", HttpStatus.NOT_FOUND);
	}
	
	//요기
	@PostMapping("/user/updateInfo")
	@ApiOperation(value = "회원정보수정", httpMethod="POST", produces="multipart/form-data")
	public Object updateInfo(InfoInputMember infoInputMember) {
		//암호화
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(infoInputMember.getPassword().getBytes());
			infoInputMember.setPassword(String.format("%040x", new BigInteger(1, md.digest())));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		String saveName = null;
		System.out.println(infoInputMember.getName());
		Member member = new Member(infoInputMember.getName(), infoInputMember.getEmail(), infoInputMember.getPassword(), infoInputMember.getIntroduce());
		member.setUid(infoInputMember.getUid());
		
		if(infoInputMember.getProfileSwitch() == 1) {
			//기존 데이터 삭제
			Member originalMember =  memberDao.getMemberByUid(infoInputMember.getUid());
			if(!originalMember.getProfileimage().isEmpty()) {
				File file = new File("/var/www/html/dist/spa/profileimg" + originalMember.getProfileimage());
				if(file.exists() == true) {
					file.delete();
				}
			}
			
			// 추가
			String UPLOAD_PATH = "/var/www/html/dist/spa/profileimg";
			UUID uuid = UUID.randomUUID();
	        saveName = uuid+"_"+infoInputMember.getProfileimage().getOriginalFilename();
	        File saveFile = new File(UPLOAD_PATH, saveName);
	        try {
				infoInputMember.getProfileimage().transferTo(saveFile);
				 member.setProfileimage(saveName);
				 saveName = "http://i4b103.p.ssafy.io/profileimg/" + saveName;
			}  catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 여기서 세이브
        memberDao.save(member);
        
		return new ResponseEntity<>(saveName, HttpStatus.OK);
	}
	
	//ㅇㅋ
	@GetMapping("/user/profile/{uid}")
	@ApiOperation(value = "개인정보가져오기")
	public Object profileInfo(@PathVariable Long uid) {
		Member member = memberDao.getMemberByUid(uid);
		member.setPassword(""); // password X
		return new ResponseEntity<>(member, HttpStatus.OK);
	}
	
	//ㅇㅋ
	@DeleteMapping("/user/delete/{uid}")
	@ApiOperation(value = "회원탈퇴")
	public Object deleteInfo(@PathVariable Long uid) {
		Optional<Member> memberOpt = memberDao.deleteMemberByUid(uid);
		if(memberOpt.isPresent())return new ResponseEntity<>("success",  HttpStatus.OK);
		else return new ResponseEntity<>("fail", HttpStatus.NOT_FOUND);
	}
}