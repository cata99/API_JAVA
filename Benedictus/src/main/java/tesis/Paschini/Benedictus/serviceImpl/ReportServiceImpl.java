package tesis.Paschini.Benedictus.serviceImpl;

import org.springframework.stereotype.Service;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Report;
import tesis.Paschini.Benedictus.repository.ReportRepository;
import tesis.Paschini.Benedictus.service.ReportService;

import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    private ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository){
        this.reportRepository=reportRepository;
    }

    @Override
    public Report saveReport(Report report){
        Optional<Report> savedReport = reportRepository.findById(report.getId());
        if(savedReport.isPresent()){
            throw new ResourceNotFoundException("Report already exist with given email:" +report.getId());
        }
        return reportRepository.save(report);
    }

    @Override
    public List<Report> getAllReport(){
        return reportRepository.findAll();
    }

    @Override
    public Optional<Report> getReportById(long id){
        return reportRepository.findById(id);
    }

    @Override
    public Report updateReport(Report updatedReport){
        return reportRepository.save(updatedReport);
    }

    @Override
    public void deleteReport(long id){
        reportRepository.deleteById(id);
    }
}
