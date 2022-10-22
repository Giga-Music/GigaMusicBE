package com.pnu.gigamusic.gigamusicbe.repository;

import com.pnu.gigamusic.gigamusicbe.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {

}
