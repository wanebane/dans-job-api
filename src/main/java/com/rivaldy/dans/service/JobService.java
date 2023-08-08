package com.rivaldy.dans.service;

import com.rivaldy.dans.dto.response.ApiRes;
import com.rivaldy.dans.dto.response.ApiResponse;
import com.rivaldy.dans.value.AppConstant;
import com.rivaldy.dans.value.FormatMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobService {

    private final DansJobService dansService;

    public ApiResponse getJobList(){
        var jobs = dansService.getJobs().stream().map(FormatMapper::jobs);
        var message = String.format(AppConstant.msgSuccess, "List Job");
        return new ApiResponse(true, message, jobs, HttpStatus.OK);
    }

    public ApiResponse getDetailJob(String id){
        var detail = dansService.getJobDetail(id);
        var message = "";
        if (detail == null){
            message = String.format(AppConstant.msgFailed, "Detail Job");
            return new ApiResponse(false, message, null, HttpStatus.NOT_FOUND);
        }
        message = String.format(AppConstant.msgSuccess, "Detail Job");
        return new ApiResponse(true, message, FormatMapper.jobDetail(detail), HttpStatus.OK);
    }

    public ApiRes getGroupListJob(){
        return new ApiRes(0, "Ok", dansService.getResultJob());
    }
}
