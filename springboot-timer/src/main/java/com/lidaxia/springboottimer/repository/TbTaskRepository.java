package com.lidaxia.springboottimer.repository;

import com.lidaxia.springboottimer.task.TbTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/11 15:55（
 */
@Repository
public interface TbTaskRepository extends JpaRepository<TbTask,String>, JpaSpecificationExecutor<TbTask> {
}
