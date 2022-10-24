package com.pnu.gigamusic.gigamusicbe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@Entity
public class Music extends BaseEntity {

    @NotBlank
    private String name;

    @NotBlank
    private String imageUrl;

    private String description;

    @Lob
    private byte[] mediaFile;

    @NotEmpty
    @ManyToMany
    private List<PlayList> playLists;

}
