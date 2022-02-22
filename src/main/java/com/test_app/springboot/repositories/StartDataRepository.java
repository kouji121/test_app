package com.test_app.springboot.repositories;

import com.test_app.springboot.StartData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StartDataRepository extends JpaRepository<StartData, Long>{

}
