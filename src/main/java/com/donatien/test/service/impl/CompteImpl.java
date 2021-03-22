package com.donatien.test.service.impl;

import com.donatien.test.common.Common;
import com.donatien.test.dto.CompteDTO;
import com.donatien.test.entities.Compte;
import com.donatien.test.entities.Transaction;
import com.donatien.test.enumeration.TypeCompte;
import com.donatien.test.repository.CompteRepository;
import com.donatien.test.repository.TransactionRepository;
import com.donatien.test.service.interfaces.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author donatien
 * @created 20/03/2021 - 11:44 AM
 * @project test
 */

@Transactional
@Service
public class CompteImpl implements CompteService {

    private final String epargne = "01 E";
    private final String cheque = "02 E";

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    @Autowired
    private Common common;


    @Override
    public Compte createCompte ( CompteDTO compteDTO ) {
        Compte newCompte = new Compte ();
        if(newCompte.getTypeCompte ().equals ( TypeCompte.CHECQUE )){
            newCompte.setNumero (common.generateRandomDigitsCode ( 11 )+ cheque);
            newCompte.setPlafondPret ( ( long ) 1000 );
            newCompte.setCumulTransaction ( ( long ) 0 );
        }else if(newCompte.getTypeCompte ().equals ( TypeCompte.EPARGNE )){
            newCompte.setNumero ( common.generateRandomDigitsCode ( 11 )+ epargne );
            newCompte.setPeriodeEpargne ( compteDTO.getPeriodeEpargne () );
        }
        newCompte.setDateCreation ( new Date (  ) );
        newCompte.setSolde ( 0 );
        newCompte.setIsActive ( true );

        return newCompte;

    }

    @Override
    public Compte save ( Compte compte ) {
        return compteRepository.save(compte);
    }

    @Override
    public Compte  consulterCompte ( String numero) {
        Compte  cp = compteRepository.findOne ( numero );
        return cp;
    }

    @Override
    public void depot ( String numero, double montant ) {
        Compte compte = consulterCompte ( numero );
        Transaction transaction = new Transaction ( new Date (  ), montant, compte );
        transactionRepository.save ( transaction );
        compte.setSolde ( compte.getSolde ()+montant );
        compteRepository.save ( compte );

    }

    @Override
    public void retrait ( String numero, double montant ) {

        Compte compte = consulterCompte ( numero );
        Transaction transaction = new Transaction ( new Date (  ), montant, compte );
        if(compte.getSolde () < montant) throw new RuntimeException ( "solde insuffisant" );
        transactionRepository.save ( transaction );
        compte.setSolde ( compte.getSolde ()-montant );
        compteRepository.save ( compte );


    }

    @Override
    public void virement ( String numero1, String numero2, double montant ) {

        retrait ( numero1, montant );
        depot ( numero2, montant );

    }

    @Override
    public Page <Transaction> listTransaction ( String numero, int page, int size ) {
        return null;
    }


    @Override
    public Boolean bloquerCompte ( String numero ) {
        return null;
    }

}
