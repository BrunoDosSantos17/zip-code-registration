package com.santosdosbruno.TelaCadastro.service;


import java.io.File;
import java.io.IOException;

public interface ReportServiceInterface {
    String requestCSVReportGeneration();
    File generateCSVReport() throws IOException;

    String getReportFilePath();

}
