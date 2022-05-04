package com.dm.favcookie.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dm.favcookie.models.Cookie;

@Repository
public interface CookieRepository extends CrudRepository<Cookie, Long>{

	List<Cookie> findAll();
}
