package com.santosdosbruno.TelaCadastro.controller;

import com.santosdosbruno.TelaCadastro.DTO.PersonDTO;
import com.santosdosbruno.TelaCadastro.service.PersonServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    private final PersonServiceInterface pessoaService;
    private static final String EXCHANGE_NAME = "default.exchange";
    private static final String QUEUE_NAME = "registration";

    @PostMapping
    public void registration(@RequestBody PersonDTO dto) {
        System.out.println(dto);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, QUEUE_NAME, dto);
    }

    @GetMapping
    public List<PersonDTO> findAll() {
        return pessoaService.findAll();
    }
}
