package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tesis.Paschini.Benedictus.repository.LifeEventRepository;

@RestController
@RequestMapping("/api/LifeEvents")
public class LifeEventController {

    @Autowired
    private LifeEventRepository lifeEventRepository;
}
