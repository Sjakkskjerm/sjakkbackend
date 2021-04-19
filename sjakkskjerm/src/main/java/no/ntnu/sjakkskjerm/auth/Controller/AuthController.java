package no.ntnu.sjakkskjerm.auth.Controller;

import no.ntnu.sjakkskjerm.auth.models.Role;
import no.ntnu.sjakkskjerm.auth.models.RoleEnum;
import no.ntnu.sjakkskjerm.auth.models.User;
import no.ntnu.sjakkskjerm.auth.repositories.RoleRepository;
import no.ntnu.sjakkskjerm.auth.repositories.UserRepository;
import no.ntnu.sjakkskjerm.auth.security.jwt.JWTUtils;
import no.ntnu.sjakkskjerm.auth.security.reqrep.JwtResponse;
import no.ntnu.sjakkskjerm.auth.security.reqrep.LoginRequest;
import no.ntnu.sjakkskjerm.auth.security.reqrep.MessageResponse;
import no.ntnu.sjakkskjerm.auth.security.reqrep.SignupRequest;
import no.ntnu.sjakkskjerm.auth.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins="*", maxAge = 3600)
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JWTUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        //System.out.println("Auth: " + authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);
        //System.out.println("JWT: " + jwt);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        //System.out.println("UD: " + userDetails.getAuthorities());

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUserId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getClub(),
                roles
                ));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {

        //Checking if username or email already exists
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Username already taken try another"));
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Email already taken try another"));
        }

        User user = new User(
                signupRequest.getUsername(),
                encoder.encode(signupRequest.getPassword()),
                signupRequest.getEmail(),
                signupRequest.getClub()
                );

        Set<String> roleStr = signupRequest.getRole();
        Set<Role> roleSet = new HashSet<>();

        if (roleStr == null) {
            Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER).orElseThrow(() -> new RuntimeException("Role not found"));
            roleSet.add(userRole);
        } else {
            roleStr.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role admRole = roleRepository.findByName(RoleEnum.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Role not found"));
                        roleSet.add(admRole);

                        break;
                    case "organizer":
                        Role orgRole = roleRepository.findByName(RoleEnum.ROLE_ORGANIZER).orElseThrow(() -> new RuntimeException("Role not found"));
                        roleSet.add(orgRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER).orElseThrow(() -> new RuntimeException("Role not found"));
                        roleSet.add(userRole);
                }
            });
        }

        user.setRoleSet(roleSet);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("Registered successfull"));

    }
}