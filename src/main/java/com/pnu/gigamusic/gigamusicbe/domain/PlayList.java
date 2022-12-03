package com.pnu.gigamusic.gigamusicbe.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.util.CollectionUtils;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PlayList extends BaseEntity {

    @NotBlank
    private String name;

    private String imageUrl;

    private String description;

    @JsonIgnore
    private Double rating;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Rating> ratings;

    public PlayList(Long id) {
        setId(id);
    }

    public Double getAverageRating() {
        if (CollectionUtils.isEmpty(getRatings())) {
            return null;
        }
        int sum = getRatings().stream()
                .mapToInt(Rating::getStars)
                .sum();
        return sum == 0 ? 0D : sum / (double) getRatings().size();
    }

}
