package com.mehulsachdeva.employeeRecords.util;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@NoArgsConstructor
@Component
public class ResponseBuilder {
    private Map<String, String> response = new LinkedHashMap<>();

    public Map<String, String> createResponse(String STATUS, String RESPONSE, String ERROR) {
        response.put("STATUS", STATUS);
        response.put("RESPONSE", RESPONSE);
        response.put("ERROR", ERROR);
        return response;
    }
}
