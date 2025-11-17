package com.example.demo9.repository;

import com.example.demo9.constant.UserDel;
import com.example.demo9.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
  Optional<Member> findByEmail(String email);

  Optional<Object> findByEmailAndUserDel(String email, UserDel userDel);
}
