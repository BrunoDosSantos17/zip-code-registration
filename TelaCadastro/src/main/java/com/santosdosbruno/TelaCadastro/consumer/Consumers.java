package com.santosdosbruno.TelaCadastro.consumer;

import com.santosdosbruno.TelaCadastro.DTO.PersonDTO;
import com.santosdosbruno.TelaCadastro.controller.NotificationController;
import com.santosdosbruno.TelaCadastro.service.PersonServiceInterface;
import com.santosdosbruno.TelaCadastro.service.ReportServiceInterface;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class Consumers {

    @Autowired
    private PersonServiceInterface pessoaService;

    @Autowired
    private ReportServiceInterface reportService;

    @Autowired
    private NotificationController notificationController;

    @RabbitListener(queues = "registration")
    public void processRegistration(PersonDTO personDTO) {
        pessoaService.creationPerson(personDTO) ;
    }

    @RabbitListener(queues = "report")
    public void receiveMessage(String message) {
        System.out.println("Received: " + message);

        try {
            File csvFile = reportService.generateCSVReport();
            System.out.println("Creation report: " + csvFile.getAbsolutePath());
            notificationController.notifyFrontend(reportService.getReportFilePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
