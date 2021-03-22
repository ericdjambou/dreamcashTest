package com.donatien.test.repository;

import com.donatien.test.entities.CodeTransfert;
import com.donatien.test.entities.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author donatien
 * @created 20/03/2021 - 12:54 AM
 * @project test
 */

@RepositoryRestResource
public interface TransactionRepository extends JpaRepository <Transaction, Long> {

    @Query("select p from Transaction p where p.compte.numero=:x")
    public Page <Transaction> listTransaction( @Param ( "x" ) String numero, Pageable pageable );
}
