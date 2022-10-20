package com.pnu.gigamusic.gigamusicbe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class PlayList extends BaseEntity {

    private String name;

    private String imageUrl;

    private String description;

    @OneToMany
    private List<Rating> ratings;

}
