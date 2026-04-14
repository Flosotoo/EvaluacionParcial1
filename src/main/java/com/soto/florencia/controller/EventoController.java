package com.soto.florencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soto.florencia.service.EvaluacionService;

@RestController
@RequestMapping("/api/v1/eventos")
public class EvaluacionController {
    @Autowired
    private EvaluacionService evaluacionService;
    
}
