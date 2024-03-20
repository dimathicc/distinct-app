package com.dimathicc.distinct.service;

import com.dimathicc.distinct.dto.PageResponse;
import com.dimathicc.distinct.dto.Request;
import com.dimathicc.distinct.dto.Response;
import com.dimathicc.distinct.exception.EmptyRequestException;
import com.dimathicc.distinct.exception.NumbersSizeException;
import com.dimathicc.distinct.model.Numbers;
import com.dimathicc.distinct.repository.NumbersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NumbersService {

    private final NumbersRepository repository;

    public Response getDistinctNumbers(Request request) {
        if (request.numbers().isEmpty()) {
            throw new EmptyRequestException("numbers не должен быть пустым");
        }
        if (request.numbers().size() > 20) {
            throw new NumbersSizeException("длина numbers не должна превышать 20 элементов");
        }
        var distinct = request.numbers()
                .stream()
                .distinct()
                .sorted()
                .toList();

        var numbers = new Numbers();
        numbers.setNumbers(request.numbers().toString());
        numbers.setDistinct(distinct.toString());
        numbers.setTimestamp(Instant.now());

        repository.save(numbers);

        return new Response(distinct);
    }

    public PageResponse getItems(int page, int size) {
        Page<Numbers> all;
        if (page == -1) {
            all = repository.findAll(PageRequest.of(0, size, Sort.by("id").descending()));
        } else {
            all = repository.findAll(PageRequest.of(page, size));
        }
        return new PageResponse(
                all.getContent(),
                all.getNumber(),
                all.getTotalPages(),
                all.getSize()
        );
    }
}
