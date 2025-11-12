package com.example.demo9.repository;

import com.example.demo9.entity.BoardReply;
import com.example.demo9.entity.QBoardReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface BoardReplyRepository extends JpaRepository<BoardReply, Long>, QuerydslPredicateExecutor<BoardReply> {

  List<BoardReply> findByBoardIdOrderById(Long boardId);
}
