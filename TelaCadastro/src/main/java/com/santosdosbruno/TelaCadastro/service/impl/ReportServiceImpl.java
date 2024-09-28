package com.santosdosbruno.TelaCadastro.service.impl;

import com.santosdosbruno.TelaCadastro.model.Persona;
import com.santosdosbruno.TelaCadastro.repository.PersonaRepository;
import com.santosdosbruno.TelaCadastro.service.ReportServiceInterface;
import lombok.Getter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportServiceInterface {
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Getter
    private String reportFilePath;

    @Override
    public String requestCSVReportGeneration() {
        String queueName = "report";
        System.out.println("Enviando mensagem para a fila: " + queueName);
        rabbitTemplate.convertAndSend("default.exchange", queueName, "Solicitação de geração de relatório");
        return "Relatório está sendo gerado. Por favor, aguarde.";
    }

    @Override
    public File generateCSVReport() throws IOException {
        List<Persona> pessoas = personaRepository.findAll();

        File tempFile = File.createTempFile("registration", ".csv");
        try (Writer writer = new FileWriter(tempFile)) {
            writer.write("ID, Nome, Telefone, CPF, Endereco, Numero, Complemento, CEP, Bairro, Cidade, UF\n");
            for (Persona pessoa : pessoas) {
                writer.write(pessoa.getId() + "," + pessoa.getName() + "," + pessoa.getPhone() + "," + pessoa.getCpf() + ","
                        + pessoa.getAddress() + "," + pessoa.getNumber() + "," + pessoa.getComplement() +
                        "," + pessoa.getZipCode() + "," + pessoa.getAddress() + "," + pessoa.getCity() + "," + pessoa.getDistrict() + "\n");
            }
        }
        System.out.println("Arquivo CSV gerado em: " + tempFile.getAbsolutePath());
        this.reportFilePath = tempFile.getAbsolutePath();
        return tempFile;
    }
}
