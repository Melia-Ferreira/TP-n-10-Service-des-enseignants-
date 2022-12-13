package champollion;

import java.util.Date;

public class Intervention {
    public Date début;
    public int durée;
    public boolean annulée = false;
    private int heureDébut;

    private Salle salle;
    private UE ue;
    private Enseignant enseignant;
    private TypeIntervention type;

    public Intervention(Enseignant enseignant, TypeIntervention type, Salle salle, UE ue, Date début, int heureDébut, int durée) {
        this.enseignant = enseignant;
        this.type = type;
        this.salle = salle;
        this.ue = ue;
        this.début = début;
        this.heureDébut = heureDébut;
        this.durée = durée;
    }

    public Date getDébut() {
        return début;
    }

    public int getDurée() {
        return durée;
    }

    public boolean isAnnulée() {
        return annulée;
    }

    public int getHeureDébut() {
        return heureDébut;
    }

    public Salle getSalle() {
        return salle;
    }

    public UE getUe() {
        return ue;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public TypeIntervention getType() {
        return type;
    }

    public void setDébut(Date début) {
        this.début = début;
    }

    public void setDurée(int durée) {
        this.durée = durée;
    }

    public void setAnnulée(boolean annulée) {
        this.annulée = annulée;
    }

    public void setHeureDébut(int heureDébut) {
        this.heureDébut = heureDébut;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public void setType(TypeIntervention type) {
        this.type = type;
    }
}
