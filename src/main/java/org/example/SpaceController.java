package org.example;

import lombok.RequiredArgsConstructor;
import org.example.service.SpaceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/space")
@RequiredArgsConstructor
public class SpaceController {

    private final SpaceService spaceService;


}
