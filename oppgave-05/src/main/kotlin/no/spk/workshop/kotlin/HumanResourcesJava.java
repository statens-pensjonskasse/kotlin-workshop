package no.spk.workshop.kotlin;

public class HumanResourcesJava {

    private final Ansatt dagligLeder;

    public HumanResourcesJava(Ansatt dagligLeder) {
        this.dagligLeder = dagligLeder;
    }

    // a)
    public String hentSjefenTil(Ansatt ansatt) {
        Avdeling department = ansatt.getAvdeling();
        if (department != null) {
            Ansatt sjef = department.getSjef();
            if (sjef != null) {
                return sjef.getNavn();
            }
        }
        return null;
    }

    // b)
    public Ansatt hentNaermesteKontaktpunkt(Ansatt ansatt) {
        Avdeling department = ansatt.getAvdeling();
        if (department != null) {
            Ansatt sjef = department.getSjef();
            if (sjef != null) {
                return sjef;
            }
        }
        return dagligLeder;
    }
}
