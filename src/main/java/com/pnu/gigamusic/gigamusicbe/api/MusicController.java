package com.pnu.gigamusic.gigamusicbe.api;

import com.pnu.gigamusic.gigamusicbe.domain.Music;
import com.pnu.gigamusic.gigamusicbe.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

import static com.pnu.gigamusic.gigamusicbe.constant.SecurityConstants.ADMIN;

@RestController
@RequestMapping("/music")
@RequiredArgsConstructor
public class MusicController {

    private final MusicService musicService;

    @RolesAllowed(ADMIN)
    @PostMapping
    public Music create(@Validated @RequestBody Music music) {
        return musicService.create(music);
    }

    @RolesAllowed(ADMIN)
    @PutMapping
    public Music update(@Validated @RequestBody Music music) {
        return musicService.update(music);
    }

    @GetMapping("/list")
    public List<Music> getList() {
        return musicService.findAll();
    }

    @RolesAllowed(ADMIN)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        musicService.delete(id);
    }

}
