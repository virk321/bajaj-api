package com.example.demo.service;

import com.example.demo.dto.RequestDTO;
import com.example.demo.dto.ResponseDTO;

public interface BFHLService {

    ResponseDTO processData(RequestDTO request);
}