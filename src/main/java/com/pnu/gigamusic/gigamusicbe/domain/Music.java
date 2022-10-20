package com.pnu.gigamusic.gigamusicbe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Music extends BaseEntity {

    private String name;

    private String imageUrl;

    private String description;

    private String fileUrl;

    @ManyToMany
    private List<PlayList> playLists;

}
