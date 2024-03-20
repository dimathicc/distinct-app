package com.dimathicc.distinct.dto;

public record ErrorResponse(
        String error,
        String details
) {
}
