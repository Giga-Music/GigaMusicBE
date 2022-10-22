package com.pnu.gigamusic.gigamusicbe.api;

import com.pnu.gigamusic.gigamusicbe.domain.Music;
import com.pnu.gigamusic.gigamusicbe.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music")
@RequiredArgsConstructor
public class MusicController {

    private final MusicService musicService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Music create(@Validated @RequestBody Music music) {
        return musicService.create(music);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public Music update(@Validated @RequestBody Music music) {
        return musicService.update(music);
    }

    @GetMapping("/list")
    public List<Music> getList() {
        return musicService.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        musicService.delete(id);
    }

}
