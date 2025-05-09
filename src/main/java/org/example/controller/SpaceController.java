package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.Space;
import org.example.service.SpaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/space")
@RequiredArgsConstructor
public class SpaceController {

    private final SpaceService spaceService;

    @GetMapping("/create-space")
    public Space createSpace(@RequestParam(name = "name") String name,
                             @RequestParam(name = "description") String description){
        return spaceService.createSpace(name, description);
    }
}
