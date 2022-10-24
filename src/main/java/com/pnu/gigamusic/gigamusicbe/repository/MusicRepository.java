package com.pnu.gigamusic.gigamusicbe.repository;

import com.pnu.gigamusic.gigamusicbe.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MusicRepository extends JpaRepository<Music, Long>, QuerydslPredicateExecutor<Music> {

}
