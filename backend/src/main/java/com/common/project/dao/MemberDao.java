package com.common.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.common.project.model.member.Member;

import lombok.Data;

public interface MemberDao extends JpaRepository<Member, Long>, MemberRepository{
	

}
