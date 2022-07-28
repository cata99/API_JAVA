package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Report;
import tesis.Paschini.Benedictus.repository.ReportRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Reports")
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping
    public List<Report> getAllReport() {
        return reportRepository.findAll();
    }

    @PostMapping
    public Report createAttribute(@RequestBody Report report) {
        return reportRepository.save(report);
    }

    @GetMapping("{id}")
    public ResponseEntity<Report> getReportById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Report report = reportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("report not exist with id:" + id));

        return ResponseEntity.ok(report);
    }

    @PutMapping("{id}")
    public ResponseEntity<Report> updateReport( @PathVariable(value = "id" ) Long id , @RequestBody Report reportDetails) throws ResourceNotFoundException{
        Report report= reportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("report not exist with id:" + id));

        report.setDate(reportDetails.getDate());
        report.setDescription(reportDetails.getDescription());
        report.setFemaleQuantity(reportDetails.getFemaleQuantity());
        report.setMaleQuantity(reportDetails.getMaleQuantity());
        report.setInstitutionId(reportDetails.getInstitutionId());
        report.setMovementId(reportDetails.getMovementId());
        report.setUserId(reportDetails.getUserId());

        final Report updatedReport = reportRepository.save(report);
        return ResponseEntity.ok(updatedReport);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteUser (@PathVariable(value = "id") Long reportId) throws ResourceNotFoundException {
        Report report= reportRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + reportId));

        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
