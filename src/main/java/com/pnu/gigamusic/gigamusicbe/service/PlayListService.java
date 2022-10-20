package com.pnu.gigamusic.gigamusicbe.service;

import com.pnu.gigamusic.gigamusicbe.domain.PlayList;
import com.pnu.gigamusic.gigamusicbe.repository.PlayListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayListService {

    private final PlayListRepository playListRepository;

    public PlayList create(PlayList playList) {
        return playListRepository.save(playList);
    }

    public PlayList update(PlayList playList) {
        return playListRepository.save(playList);
    }

    public List<PlayList> findAll() {
        return playListRepository.findAll();
    }

    public void delete(String id) {
        playListRepository.deleteById(id);
    }

}
