package no.spk.workshop.kotlin;

public class MedlemDto {

    private String brukernavn;
    private Boolean erAktiv;

    public MedlemDto(String brukernavn, Boolean erAktiv) {
        this.brukernavn = brukernavn;
        this.erAktiv = erAktiv;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public Boolean getErAktiv() {
        return erAktiv;
    }

    public void setErAktiv(Boolean aktivStatus) {
        erAktiv = aktivStatus;
    }
}
