package com.BharatPays.jwtAuth;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.BharatPays.jwtAuth.JwtTokenUtil;
import com.BharatPays.jwtAuth.JwtRequest;
import com.BharatPays.jwtAuth.JwtResponse;
@RestController
@CrossOrigin
public class JwtAuthenticationController {
@Autowired
private AuthenticationManager authenticationManager;
@Autowired
private JwtTokenUtil jwtTokenUtil;
@Autowired
private JwtUserDetailsService userDetailsService;


@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
	System.out.println("userName  "+authenticationRequest.getUsername());
	System.out.println("password  "+authenticationRequest.getPassword());
authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
System.out.println("userName  "+authenticationRequest.getUsername());
System.out.println("password  "+authenticationRequest.getPassword());
final UserDetails userDetails = userDetailsService
.loadUserByUsername(authenticationRequest.getUsername());
System.out.println("userDetails loaded from in memory");
System.out.println(userDetails.getUsername());
System.out.println(userDetails.getPassword());
final String token = jwtTokenUtil.generateToken(userDetails);
return ResponseEntity.ok(new JwtResponse(token));
}

private void authenticate(String username, String password) throws Exception {
try {
	System.out.println("inside authenticate method "+ username + "  "+password);
authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
} catch (DisabledException e) {
throw new Exception("USER_DISABLED", e);
} catch (BadCredentialsException e) {
throw new Exception("INVALID_CREDENTIALS", e);
}
}
}
