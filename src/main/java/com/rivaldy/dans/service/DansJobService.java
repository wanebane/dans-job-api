package com.rivaldy.dans.service;

import com.rivaldy.dans.dto.response.DansJobResponse;
import com.rivaldy.dans.dto.pattern.JobUrl;
import com.rivaldy.dans.dto.response.LocationResponse;
import com.rivaldy.dans.dto.response.ResultLocationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<ResultLocationResponse> getResultJob(){
        var jobs = getJobs();
        Set<String> locations = new HashSet<>();
        jobs.forEach(v -> locations.add(v.location()));

        List<LocationResponse> listLoc = new ArrayList<>();
        locations.forEach(l -> {
            var listJob = jobs.stream().filter(j -> j.location().equals(l)).collect(Collectors.toList());
            var loc = new LocationResponse(l, listJob);
            listLoc.add(loc);
        });
        return List.of(new ResultLocationResponse(listLoc));
    }
}
