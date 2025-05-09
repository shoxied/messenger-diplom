package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Space;
import org.example.repo.SpaceRepository;
import org.example.service.SpaceService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class SpaceServiceImpl implements SpaceService {

    private final SpaceRepository spaceRepository;

    @Override
    public Space createSpace(String name, String description) {

        Space space = Space.builder()
                .name(name)
                .description(description)
                .create_date(OffsetDateTime.now())
                .build();

        return spaceRepository.save(space);
    }

}
