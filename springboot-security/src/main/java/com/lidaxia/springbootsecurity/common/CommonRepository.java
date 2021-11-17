package com.lidaxia.springbootsecurity.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/16 15:44（
 */
@NoRepositoryBean
public interface CommonRepository<E,T> extends JpaRepository<E,T>, JpaSpecificationExecutor<E> {

}