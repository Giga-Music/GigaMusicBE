package com.pnu.gigamusic.gigamusicbe.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

}
