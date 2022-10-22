package com.pnu.gigamusic.gigamusicbe.api;

import com.pnu.gigamusic.gigamusicbe.domain.PlayList;
import com.pnu.gigamusic.gigamusicbe.service.PlayListService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playList")
@RequiredArgsConstructor
public class PlayListController {

    private final PlayListService playListService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public PlayList create(@Validated @RequestBody PlayList playList) {
        return playListService.create(playList);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public PlayList update(@Validated @RequestBody PlayList playList) {
        return playListService.update(playList);
    }

    @GetMapping("/list")
    public List<PlayList> getList() {
        return playListService.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playListService.delete(id);
    }

}
