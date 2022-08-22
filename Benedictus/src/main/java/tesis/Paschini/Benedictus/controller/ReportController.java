package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.Report;
import tesis.Paschini.Benedictus.repository.ReportRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/reports/")
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping
    public List<Report> getAllReports(){ return reportRepository.findAll();}

    @GetMapping("{id}")
    public ResponseEntity getReportById(@PathVariable long id){
        Report report = reportRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        return ResponseEntity.ok(report);
    }

    @PostMapping
    public Report createReport(@RequestBody Report report){
        return reportRepository.save(report);
    }
}
