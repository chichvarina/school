package ru.hogwarts.school.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.repository.AvatarPaginationRepository;
import ru.hogwarts.school.repository.AvatarRepository;

import java.util.Collection;
import java.util.List;

@Service
public class AvatarService {

    private final AvatarPaginationRepository avatarPaginationRepository;

    public AvatarService(AvatarPaginationRepository avatarPaginationRepository) {
        this.avatarPaginationRepository = avatarPaginationRepository;
    }


    public List<Avatar> findAll(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return avatarPaginationRepository.findAll(pageRequest).getContent();
    }

}
