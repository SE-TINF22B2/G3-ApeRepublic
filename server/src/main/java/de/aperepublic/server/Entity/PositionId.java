package de.aperepublic.server.Entity;

import java.io.Serializable;

public class PositionId implements Serializable {

    private Integer idUser;

    private String symbol;

    public PositionId(Integer idUser, String symbol) {
        this.idUser = idUser;
        this.symbol = symbol;
    }
    public PositionId() {
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
