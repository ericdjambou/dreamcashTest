package com.donatien.test.common;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author donatien
 * @created 20/03/2021 - 12:31 PM
 * @project test
 */

public class Common {

    private static final Random RANDOM = new SecureRandom ();
    public static final String DIGITS = "0123456789";


    // Générer un code aléatoire ne contenant que des chiffres et possédant une certaine longueur
    public String generateRandomDigitsCode(int length) {
        String code = "";
        for (int i=0; i < length; i++)
        {
            int index = (int)(RANDOM.nextDouble()*DIGITS.length());
            code += DIGITS.substring(index, index+1);
        }
        return code;
    }
}
