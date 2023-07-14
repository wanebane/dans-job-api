package com.rivaldy.dans.dto.response;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class JobDetailResponse extends JobsResponse {

    private String howToApply;
    private String createdAt;
    private String description;
}
