package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.BFHLService;

import org.springframework.web.bind.annotation.*;

@RestController
public class BFHLController {

    private final BFHLService service;

    public BFHLController(BFHLService service) {
        this.service = service;
    }

    @GetMapping("/bfhl")
    public String healthCheck() {
        return "BFHL API Running";
    }

    @PostMapping("/bfhl")
    public ResponseDTO process(
            @RequestBody RequestDTO request
    ) {
        return service.processData(request);
    }
}
