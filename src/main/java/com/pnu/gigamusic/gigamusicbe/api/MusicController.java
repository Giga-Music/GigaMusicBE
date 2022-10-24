package com.pnu.gigamusic.gigamusicbe.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pnu.gigamusic.gigamusicbe.api.dto.MusicInfo;
import com.pnu.gigamusic.gigamusicbe.domain.Music;
import com.pnu.gigamusic.gigamusicbe.service.MusicService;
import com.pnu.gigamusic.gigamusicbe.util.JsonParamEditor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/music")
@RequiredArgsConstructor
public class MusicController {

    private final MusicService musicService;
    private final ObjectMapper jsonMapper;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Music.class, new JsonParamEditor<>(jsonMapper, Music.class));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Music create(@ModelAttribute("data") @Valid Music music,
                        @RequestParam(name = "file") MultipartFile file) {
        return musicService.create(music, file);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Music update(@ModelAttribute("data") @Valid Music music,
                        @RequestParam(name = "file") MultipartFile file) {
        return musicService.update(music, file);
    }

    @GetMapping("/list")
    public List<MusicInfo> getList(@RequestParam(required = false) Long playListId, @RequestParam(required = false) Long limit) {
        return musicService.findAll(playListId, limit);
    }

    @GetMapping("/{id}")
    public Music getById(@PathVariable Long id) {
        return musicService.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        musicService.delete(id);
    }

}
