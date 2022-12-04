package com.pnu.gigamusic.gigamusicbe.api;

import com.pnu.gigamusic.gigamusicbe.domain.PlayList;
import com.pnu.gigamusic.gigamusicbe.service.PlayListService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/playList")
@RequiredArgsConstructor
public class PlayListController {

    private final PlayListService playListService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public PlayList create(@Valid @RequestBody PlayList playList) {
        return playListService.create(playList);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public PlayList update(@Valid @RequestBody PlayList playList) {
        return playListService.update(playList);
    }

    @GetMapping("/{id}")
    public PlayList getById(@PathVariable Long id) {
        return playListService.getById(id);
    }

    @GetMapping("/list")
    public List<PlayList> getList(@RequestParam(required = false) String name, @RequestParam(required = false) String sort) {
        return playListService.findAll(name, sort);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playListService.delete(id);
    }

    @PostMapping("/{id}/addRating")
    public void addRating(@PathVariable Long id, @RequestParam Integer rating) {
        playListService.addRating(id, rating);
    }

}
