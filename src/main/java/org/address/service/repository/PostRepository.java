package org.address.service.repository;

import org.address.service.entites.Person;
import org.address.service.entites.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}
