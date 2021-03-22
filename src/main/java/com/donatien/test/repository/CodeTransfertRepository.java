package com.donatien.test.repository;

import com.donatien.test.entities.CodeTransfert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author donatien
 * @created 20/03/2021 - 12:56 AM
 * @project test
 */

@RepositoryRestResource
public interface CodeTransfertRepository extends JpaRepository<CodeTransfert, Long> {
}
