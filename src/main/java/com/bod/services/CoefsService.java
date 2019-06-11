package com.bod.services;

import com.bod.entity.Gender;
import com.bod.repository.CoefsRepository;
import com.bod.repository.specifications.CoefsReadMensSpecification;
import com.bod.repository.specifications.CoefsReadWomensSpecification;
import com.bod.repository.specifications.SQLSpecification;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoefsService {
    private static final Logger LOG = Logger.getLogger(CoefsService.class);

    public double[] getCoefs(Gender gender) {
        CoefsRepository coefsRepository = new CoefsRepository();
        SQLSpecification genderSpecification;

        if (gender == Gender.M) {
            genderSpecification = new CoefsReadMensSpecification();
        } else {
            genderSpecification = new CoefsReadWomensSpecification();
        }

        double[] coefs = null;
        try (ResultSet resutlSet = coefsRepository
                .specificReadQuery(genderSpecification)) {

            coefs = new double[4];
            int ind = 0;
            while (resutlSet.next()) {
                coefs[ind] = resutlSet.getDouble(1);
                ind++;
            }

            LOG.info("Get coefs:" + coefs[0] + " " + coefs[1] + " "
                    + coefs[2] + " " + coefs[3] + " ");
        } catch (SQLException e) {
            LOG.fatal("Failed to get coefs: " + e);
        }

        return coefs;
    }
}
