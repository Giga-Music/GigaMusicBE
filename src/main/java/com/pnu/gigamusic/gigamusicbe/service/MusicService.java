package com.pnu.gigamusic.gigamusicbe.service;

import com.pnu.gigamusic.gigamusicbe.domain.Music;
import com.pnu.gigamusic.gigamusicbe.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;

    public Music create(Music music) {
        return musicRepository.save(music);
    }

    public Music update(Music music) {
        return musicRepository.save(music);
    }

    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    public void delete(String id) {
        musicRepository.deleteById(id);
    }

}
