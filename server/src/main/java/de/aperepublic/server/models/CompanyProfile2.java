package de.aperepublic.server.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CompanyProfile2 {
    @SerializedName("country")
    private String country = null;

    @SerializedName("currency")
    private String currency = null;

    @SerializedName("exchange")
    private String exchange = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("ticker")
    private String ticker = null;

    @SerializedName("ipo")
    private String ipo = null;

    @SerializedName("marketCapitalization")
    private Float marketCapitalization = null;

    @SerializedName("shareOutstanding")
    private Float shareOutstanding = null;

    @SerializedName("logo")
    private String logo = null;

    @SerializedName("phone")
    private String phone = null;

    @SerializedName("weburl")
    private String weburl = null;

    @SerializedName("finnhubIndustry")
    private String finnhubIndustry = null;

}
