package tesis.Paschini.Benedictus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tesis.Paschini.Benedictus.repository.AuthorityTypeRepository;

@RestController
@RequestMapping("/api/AuthorityTypes")
public class AuthorityTypeController {

    private AuthorityTypeRepository authorityTypeRepository;

}
