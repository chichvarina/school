package ru.hogwarts.school.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.hogwarts.school.model.Avatar;

public interface AvatarPaginationRepository extends PagingAndSortingRepository<Avatar, Long> {

}