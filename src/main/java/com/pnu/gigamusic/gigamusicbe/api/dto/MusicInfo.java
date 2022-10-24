package com.pnu.gigamusic.gigamusicbe.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MusicInfo {

    private Long id;

    private String name;

    private String imageUrl;

    private String description;

}
