package com.nova.app.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Content {
    private long contentId;
    private Long userId;
    private String contentText;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate contentTimeStamp;
    private Integer repostCount;
    private Integer likeCount;

    public Content() {

    }
}
