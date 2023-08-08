package com.rivaldy.dans.dto.response;

import com.fasterxml.jackson.annotation.JsonAlias;

public record LocationDetailResponse(String id, String type, String url, @JsonAlias("created_at") String createdAt,
                                     String company, @JsonAlias("company_url") String companyUrl, String location,
                                     String title, String description) {
}
