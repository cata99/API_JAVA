package tesis.Paschini.Benedictus.service;
import tesis.Paschini.Benedictus.models.Report;

import java.util.List;
import java.util.Optional;

public interface ReportService {
    Report saveReport(Report report);

    List<Report> getAllReport();

    Optional<Report> getReportById(long id);

    Report updateReport(Report updatedReport);

    void deleteReport(long id);
}