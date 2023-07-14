package com.rivaldy.dans.service;

import com.rivaldy.dans.dto.response.DansJobResponse;
import com.rivaldy.dans.dto.pattern.JobUrl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class DansJobService {

    private final RestTemplate restTemplate;
    private final JobUrl jobUrl;

    public List<DansJobResponse> getJobs(){
        var response = restTemplate.getForObject(jobUrl.list(), DansJobResponse[].class);
        if (response!=null){
            return List.of(response);
        }
        return List.of();
    }

    public DansJobResponse getJobDetail(String id){
        String url = jobUrl.detail() + id;
        return restTemplate.getForObject(url, DansJobResponse.class);
    }
}
