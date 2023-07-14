package com.rivaldy.dans.dto.response;

import lombok.*;

@Getter
@Setter
public class JobsResponse {

    private String jobId;
    private String company;
    private String companyLogo;
    private String title;
    private String type;
    private String location;
    private String url;
}
