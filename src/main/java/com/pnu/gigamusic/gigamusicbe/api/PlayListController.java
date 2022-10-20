package com.pnu.gigamusic.gigamusicbe.api;

import com.pnu.gigamusic.gigamusicbe.domain.PlayList;
import com.pnu.gigamusic.gigamusicbe.service.PlayListService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

import static com.pnu.gigamusic.gigamusicbe.constant.SecurityConstants.ADMIN;

@RestController
@RequestMapping("/playList")
@RequiredArgsConstructor
public class PlayListController {

    private final PlayListService playListService;

    @RolesAllowed(ADMIN)
    @PostMapping
    public PlayList create(@Validated @RequestBody PlayList playList) {
        return playListService.create(playList);
    }

    @RolesAllowed(ADMIN)
    @PutMapping
    public PlayList update(@Validated @RequestBody PlayList playList) {
        return playListService.update(playList);
    }

    @GetMapping("/list")
    public List<PlayList> getList() {
        return playListService.findAll();
    }

    @RolesAllowed(ADMIN)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        playListService.delete(id);
    }

}
