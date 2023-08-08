package com.rivaldy.dans.dto.response;

import java.util.List;

public record LocationResponse(String location, List<DansJobResponse> data) {
}
