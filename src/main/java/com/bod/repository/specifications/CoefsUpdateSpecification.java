package com.bod.repository.specifications;

public class CoefsUpdateSpecification implements SQLSpecification {
    private int id;
    private double forMen, forWomen;

    public CoefsUpdateSpecification(int id, double forMen, double forWomen) {
        this.id = id;
        this.forMen = forMen;
        this.forWomen = forWomen;
    }

    @Override
    public String toSqlClauses() {
        return String.format("UPDATE coefs SET men=%f, women=%f WHERE id=%d",
                forMen, forWomen, id);
    }
}
