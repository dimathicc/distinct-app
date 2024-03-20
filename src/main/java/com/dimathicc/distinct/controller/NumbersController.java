package com.dimathicc.distinct.controller;

import com.dimathicc.distinct.dto.PageResponse;
import com.dimathicc.distinct.dto.Request;
import com.dimathicc.distinct.dto.Response;
import com.dimathicc.distinct.model.Numbers;
import com.dimathicc.distinct.service.NumbersService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NumbersController {

    private final NumbersService service;

    @PostMapping
    public ResponseEntity<Response> getDistinct(@RequestBody Request request) {
        return ResponseEntity.ok(service.getDistinctNumbers(request));
    }

    @GetMapping
    public ResponseEntity<PageResponse> getPageOfItems(
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "-1") int page
            ) {
        return ResponseEntity.ok(service.getItems(page, size));
    }
}
