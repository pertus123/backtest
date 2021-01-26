package com.common.project.dao;

import java.util.Optional;

import com.common.project.model.member.Member;

public interface MemberRepository {
	Optional<Member> deleteMemberByUid(Long uid);
	Optional<Member> findMemberByEmailAndPassword(String email, String password);
	Optional<Member> findMemberByEmail(String email);
	Member getMemberByUid(Long uid);
	Member getMemberByEmail(String email);

}
