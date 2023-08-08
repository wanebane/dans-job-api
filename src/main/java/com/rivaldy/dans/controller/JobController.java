package com.rivaldy.dans.controller;

import com.rivaldy.dans.dto.response.ApiRes;
import com.rivaldy.dans.dto.response.ApiResponse;
import com.rivaldy.dans.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/job")
@AllArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping
    public ResponseEntity<ApiResponse> getListJob(){
        var response = jobService.getJobList();
        return new ResponseEntity<>(response, response.status());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getDetailJob(@PathVariable("id") String jobId){
        var response = jobService.getDetailJob(jobId);
        return new ResponseEntity<>(response, response.status());
    }

    @GetMapping("/group")
    public ResponseEntity<ApiRes> getJobGrouping(){
        return ResponseEntity.ok(jobService.getGroupListJob());
    }
}


