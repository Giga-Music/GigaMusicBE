package com.pnu.gigamusic.gigamusicbe.domain;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rating extends BaseEntity {

    private Integer stars;

}
