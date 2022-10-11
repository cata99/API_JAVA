package tesis.Paschini.Benedictus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.model.*;
import tesis.Paschini.Benedictus.payload.request.LoginRequest;
import tesis.Paschini.Benedictus.payload.request.SignupRequest;
import tesis.Paschini.Benedictus.payload.response.JwtResponse;
import tesis.Paschini.Benedictus.payload.response.MessageResponse;
import tesis.Paschini.Benedictus.repository.GroupRepository;
import tesis.Paschini.Benedictus.repository.PersonalInformationRepository;
import tesis.Paschini.Benedictus.repository.RoleRepository;
import tesis.Paschini.Benedictus.repository.UserRepository;
import tesis.Paschini.Benedictus.security.jwt.JwtUtils;
import tesis.Paschini.Benedictus.security.services.UserDetailsImpl;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PersonalInformationRepository personalInformationRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if(!groupRepository.existsById(signUpRequest.getGroup().getId())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Group does not exist"));
        }
        Group group = signUpRequest.getGroup();

        // Create new users personal info
        PersonalInformation personalInformation = new PersonalInformation(signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getPhone(), signUpRequest.getIdentificationNumber(), signUpRequest.getGender(), signUpRequest.getEmail());
        PersonalInformation personalInformationSaved = personalInformationRepository.save(personalInformation);



        Date date=  new Date();

        // Create new user's account
        User user = new User(signUpRequest.getReferent(),date, signUpRequest.getUsername(),
                encoder.encode(signUpRequest.getPassword()),personalInformationSaved,group, true);


        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_VOLUNTARIO)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "referente":
                        Role modRole = roleRepository.findByName(ERole.ROLE_REFERENTE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_VOLUNTARIO)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
