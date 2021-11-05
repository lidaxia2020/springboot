package com.lidaxia.springbootasync.repository;

import com.lidaxia.springbootasync.pojo.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author lijiannan
 * @desc
 * @date 2021/11/5 17:59（
 */
@Repository
public interface TbUserRepository extends JpaRepository<TbUser, Integer>, JpaSpecificationExecutor<TbUser> {
}