package org.pvhees.katas.jamigrate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FlowAant {

    private String aantekening;
    private String lidnummer;
    private String postcode;
    private String voertuig;
    private String hashForKeyFields;

    @JsonCreator
    public FlowAant(@JsonProperty("aantekening") String aantekening,
                    @JsonProperty("lidnummer") String lidnummer,
                    @JsonProperty("postcode") String postcode,
                    @JsonProperty("voertuig") String voertuig) {
        this.aantekening = aantekening;
        this.lidnummer = lidnummer;
        this.postcode = postcode;
        this.voertuig = voertuig;
    }

    public String getAantekening() {
        return aantekening;
    }

    public String getLidnummer() {
        return lidnummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getVoertuig() {
        return voertuig;
    }

    public String getHashForKeyFields() {
        return hashForKeyFields;
    }

    @Override
    public String toString() {
        return "FlowAant{" +
                "aantekening='" + aantekening + '\'' +
                ", lidnummer='" + lidnummer + '\'' +
                ", postcode='" + postcode + '\'' +
                ", voertuig='" + voertuig + '\'' +
                '}';
    }

    public void setAantekening(String aantekening) {
        this.aantekening = aantekening;
    }

    public void setLidnummer(String lidnummer) {
        this.lidnummer = lidnummer;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setVoertuig(String voertuig) {
        this.voertuig = voertuig;
    }

    public void setHashForKeyFields(String hashForKeyFields) {
        this.hashForKeyFields = hashForKeyFields;
    }
}
