package group.six.adventurexp.martin;

public class Aktivitet {

    int pris;
    String navn;
    String beskrivelse;
    String krav;


    public Aktivitet(int pris, String navn, String beskrivelse, String krav) {
        this.pris = pris;
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.krav = krav;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public String getNavn() {
        return navn;
    }


    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String getKrav() {
        return krav;
    }

    public void setKrav(String krav) {
        this.krav = krav;
    }

    @Override
    public String toString() {
        return "Aktivitet{" +
                "pris=" + pris +
                ", navn='" + navn + '\'' +
                ", beskrivelse='" + beskrivelse + '\'' +
                ", krav='" + krav + '\'' +
                '}';
    }
}
