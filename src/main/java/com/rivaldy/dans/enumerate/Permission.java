package com.rivaldy.dans.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Permission {

    ADMIN_CREATE("admin:create"),
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete"),
    COMPANY_CREATE("company:create"),
    COMPANY_READ("company:read"),
    COMPANY_UPDATE("company:update"),
    COMPANY_DELETE("company:delete"),
    JOB_SEEKER_CREATE("job_seeker:create"),
    JOB_SEEKER_READ("job_seeker:read"),
    JOB_SEEKER_UPDATE("job_seeker:update"),
    JOB_SEEKER_DELETE("job_seeker:delete");

    @Getter
    private final String permission;
}
