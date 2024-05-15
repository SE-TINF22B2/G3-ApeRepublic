package de.aperepublic.server.Entity;

import java.io.Serializable;

public class PositionId implements Serializable {

    private Integer idUser;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    private String isin;

    public PositionId(Integer idUser, String isin) {
        this.idUser = idUser;
        this.isin = isin;
    }
    public PositionId() {
    }

}
