package org.example.service;

import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.RequestParam;

public interface AuthenticationService {

    String register(String email,
                    String phone_number,
                    String first_name,
                    String last_name,
                    String password) throws BadRequestException;
}
