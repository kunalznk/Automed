package com.kz.automed;

public class Member {

    private String pateint_name;
    private int patient_age;
    private String patient_diseae;
    private int patient_gno;

    public Member() {
    }

    public String getPateint_name() {
        return pateint_name;
    }

    public void setPateint_name(String pateint_name) {
        this.pateint_name = pateint_name;
    }

    public int getPatient_age() {
        return patient_age;
    }

    public void setPatient_age(int patient_age) {
        this.patient_age = patient_age;
    }

    public String getPatient_diseae() {
        return patient_diseae;
    }

    public void setPatient_diseae(String patient_diseae) {
        this.patient_diseae = patient_diseae;
    }

    public int getPatient_gno() {
        return patient_gno;
    }

    public void setPatient_gno(int patient_gno) {
        this.patient_gno = patient_gno;
    }
}
