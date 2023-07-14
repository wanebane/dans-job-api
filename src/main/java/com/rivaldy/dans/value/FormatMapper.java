package com.rivaldy.dans.value;

import com.rivaldy.dans.dto.response.DansJobResponse;
import com.rivaldy.dans.dto.response.JobDetailResponse;
import com.rivaldy.dans.dto.response.JobsResponse;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class FormatMapper {

    public static String convertDateTime(String createdAt){
//        "Wed May 19 00:49:17 UTC 2021"
//        String dateStyle = "E MMM dd HH:mm:ss z yyyy";
        var toDateTime = LocalDateTime.parse(createdAt, DateTimeFormatter.ofPattern(AppConstant.dateStyleDans));
//        return dateTime.format(DateTimeFormatter.ofPattern(AppConstant.fmtDateTime));
        var sdf = new SimpleDateFormat(AppConstant.fmtDateTime);
        var timeZone = Calendar.getInstance().getTimeZone().getID();
        sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
        return sdf.format(Date.from(toDateTime.toLocalDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
    }

    public static JobsResponse jobs(DansJobResponse detail){
        var response = new JobsResponse();
        response.setJobId(detail.id());
        response.setCompany(detail.company());
        response.setCompanyLogo(detail.companyLogo());
        response.setTitle(detail.title());
        response.setType(detail.type());
        response.setLocation(detail.location());
        response.setUrl(detail.url());
        return response;
    }

    public static JobDetailResponse jobDetail(DansJobResponse detail){
        var response = new JobDetailResponse();
        response.setJobId(detail.id());
        response.setCompany(detail.company());
        response.setCompanyLogo(detail.companyLogo());
        response.setTitle(detail.title());
        response.setType(detail.type());
        response.setLocation(detail.location());
        response.setUrl(detail.url());
        response.setHowToApply(detail.howToApply());
        response.setCreatedAt(convertDateTime(detail.createdAt()));
        response.setDescription(detail.description());
        return response;
    }
}
