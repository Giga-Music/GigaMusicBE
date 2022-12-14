package com.pnu.gigamusic.gigamusicbe.service;

import com.pnu.gigamusic.gigamusicbe.domain.PlayList;
import com.pnu.gigamusic.gigamusicbe.domain.Rating;
import com.pnu.gigamusic.gigamusicbe.repository.PlayListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayListService {

    private final PlayListRepository playListRepository;

    public PlayList create(PlayList playList) {
        playList.setRating(playList.getAverageRating());
        return playListRepository.save(playList);
    }

    public PlayList update(PlayList playList) {
        PlayList existent = playListRepository.getById(playList.getId());
        existent.setName(playList.getName());
        existent.setImageUrl(playList.getImageUrl());
        existent.setDescription(playList.getDescription());
        existent.setRating(existent.getAverageRating());
        return playListRepository.save(existent);
    }

    public List<PlayList> findAll(String name, String sort) {
        return playListRepository.findAll(name, sort);
    }

    public PlayList getById(Long id) {
        return playListRepository.getById(id);
    }

    public void delete(Long id) {
        playListRepository.deleteById(id);
    }

    public void addRating(Long id, Integer rating) {
        playListRepository.findById(id)
                .ifPresent(playList -> {
                    List<Rating> ratings = playList.getRatings();
                    ratings.add(Rating.builder().stars(rating).build());
                    update(playList);
                });
    }

}
