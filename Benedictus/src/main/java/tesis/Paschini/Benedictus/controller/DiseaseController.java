package tesis.Paschini.Benedictus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tesis.Paschini.Benedictus.repository.DiseaseRepository;

@RestController
@RequestMapping("/api/Diseases")
public class DiseaseController {

    private DiseaseRepository diseaseRepository;
}
