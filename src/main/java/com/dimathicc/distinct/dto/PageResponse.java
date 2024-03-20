package com.dimathicc.distinct.dto;

import com.dimathicc.distinct.model.Numbers;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

public record PageResponse(List<Numbers> items, Integer page, Integer pages, Integer size) { }
