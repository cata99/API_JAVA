package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tesis.Paschini.Benedictus.repository.UnitRepository;

@RestController
@RequestMapping("/api/Units")
public class UnitController {

    @Autowired
    private UnitRepository unitRepository;

}
