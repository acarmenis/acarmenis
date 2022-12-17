package com.example.demo.controller;

import com.example.demo.dto.RequestData;
import com.example.demo.services.SortService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200") //4200
public class AppController {

    private final SortService sortService;

    @PostMapping("/list/sort")
    private ResponseEntity<List<Integer>> addUser(@RequestBody RequestData requestData) {

        int [] arr = requestData.getList().stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();

        sortService.quickSort(arr, 0, arr.length-1);

        return ResponseEntity.ok().body(Arrays.stream(sortService.getArray()).boxed().collect(Collectors.toList()));
    }
}
