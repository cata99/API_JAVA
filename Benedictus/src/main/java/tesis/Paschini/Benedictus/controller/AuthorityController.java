package tesis.Paschini.Benedictus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tesis.Paschini.Benedictus.repository.AuthorityRepository;

@RestController
@RequestMapping("/api/Authorities")
public class AuthorityController {

    private AuthorityRepository authorityRepository;
}
