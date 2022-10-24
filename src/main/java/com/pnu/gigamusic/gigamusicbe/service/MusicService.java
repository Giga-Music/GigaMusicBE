package com.pnu.gigamusic.gigamusicbe.service;

import com.pnu.gigamusic.gigamusicbe.api.dto.MusicInfo;
import com.pnu.gigamusic.gigamusicbe.domain.Music;
import com.pnu.gigamusic.gigamusicbe.domain.QMusic;
import com.pnu.gigamusic.gigamusicbe.repository.MusicRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.pnu.gigamusic.gigamusicbe.util.QueryDslUtil.getQueryFactory;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;

    @SneakyThrows
    public Music create(Music music, MultipartFile file) {
        validateAndPopulateFile(music, file);
        return musicRepository.save(music);
    }

    @SneakyThrows
    public Music update(Music music, MultipartFile file) {
        validateAndPopulateFile(music, file);
        return musicRepository.save(music);
    }

    private static void validateAndPopulateFile(Music music, MultipartFile file) throws IOException {
        if (file == null || file.getBytes().length == 0) {
            throw new IllegalArgumentException("Not Empty File is required!");
        }
        if (!file.getOriginalFilename().endsWith(".mp3")) {
            throw new IllegalArgumentException("Support only following file types: .mp3");
        }
        music.setMediaFile(file.getBytes());
    }

    public List<MusicInfo> findAll(Long playListId, Long limit) {
        QMusic qMusic = QMusic.music;
        BooleanBuilder predicate = new BooleanBuilder();
        if (playListId != null) {
            predicate.and(qMusic.playLists.any().id.eq(playListId));
        }
        return getQueryFactory()
                .select(Projections.constructor(MusicInfo.class, qMusic.id, qMusic.name, qMusic.imageUrl, qMusic.description))
                .from(qMusic)
                .where(predicate)
                .limit(limit == null ? Integer.MAX_VALUE : limit)
                .fetch();
    }

    public Music getById(Long id) {
        return musicRepository.getOne(id);
    }

    public void delete(Long id) {
        musicRepository.deleteById(id);
    }

}
