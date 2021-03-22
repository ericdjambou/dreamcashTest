package com.donatien.test.service.interfaces;

import com.donatien.test.dto.CompteDTO;
import com.donatien.test.entities.Compte;
import com.donatien.test.entities.Transaction;
import org.springframework.data.domain.Page;

/**
 * @author donatien
 * @created 20/03/2021 - 11:25 AM
 * @project test
 */

public interface CompteService {

    Compte createCompte( CompteDTO compteDTO);

    Compte save(Compte compte);

    public Compte consulterCompte ( String numero);
    public void depot (String numero, double montant);
    public void retrait (String numero, double montant);
    public void virement (String numero1, String numero2,  double montant);
    public Page <Transaction> listTransaction(String numero, int page,  int size);
    public Boolean bloquerCompte (String numero);

}
