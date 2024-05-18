package ControlWork2_var2;

public class BirthData {
    private String race;
    private int birthWeight;
    private boolean smoker;
    private int gestation;
    private byte education;


    public BirthData(String race, int birthWeight, boolean smoken, int gestation, byte education) {
        this.race = race;
        this.birthWeight = birthWeight;
        this.smoker = smoken;
        this.gestation = gestation;
        this.education = education;
    }

    public String getRace() {
        return race;
    }

    public int getBirthWeight() {
        return birthWeight;
    }

    public byte getEducation() {
        return education;
    }

    public boolean isSmoken() {
        return smoker;
    }

    public int getGestation() {
        return gestation;
    }
}
