package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Report;
import tesis.Paschini.Benedictus.service.ReportService;

import java.util.List;

@RestController
@RequestMapping("/api/Reports/")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public List<Report> getAllReport() {
        return reportService.getAllReport();
    }

    @PostMapping
    public Report createAttribute(@RequestBody Report report) {
        return reportService.saveReport(report);
    }

    @GetMapping("{id}")
    public ResponseEntity<Report> getReportById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Report report = reportService.getReportById(id)
                .orElseThrow(() -> new ResourceNotFoundException("report not exist with id:" + id));

        return ResponseEntity.ok(report);
    }

    @PutMapping("{id}")
    public ResponseEntity<Report> updateReport( @PathVariable(value = "id" ) Long id , @RequestBody Report reportDetails) throws ResourceNotFoundException{
        Report report= reportService.getReportById(id)
                .orElseThrow(() -> new ResourceNotFoundException("report not exist with id:" + id));

        report.setDate(reportDetails.getDate());
        report.setDescription(reportDetails.getDescription());
        report.setFemaleQuantity(reportDetails.getFemaleQuantity());
        report.setMaleQuantity(reportDetails.getMaleQuantity());
        report.setInstitutionId(reportDetails.getInstitutionId());
        report.setMovementId(reportDetails.getMovementId());
        report.setUserId(reportDetails.getUserId());

        final Report updatedReport = reportService.saveReport(report);
        return ResponseEntity.ok(updatedReport);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteReport (@PathVariable(value = "id") Long reportId) throws ResourceNotFoundException {
        reportService.deleteReport(reportId);

        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }
}
