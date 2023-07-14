package com.rivaldy.dans.dto.response;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DansJobResponse(String id, String type, String url, @JsonAlias("created_at") String createdAt, String company,
                              @JsonAlias("company_url") String companyUrl, String location, String title, String description,
                              @JsonAlias("how_to_apply") String howToApply, @JsonAlias("company_logo") String companyLogo){

}
