package champollion;

public class ServicePrevu {

	public UE ue;
    public Enseignant enseignant;
    public int volumeCM;
    public int volumeTD;
    public int volumeTP;


    public ServicePrevu(UE ue, Enseignant enseignant, int volumeCM, int volumeTD, int volumeTP) {
        this.ue = ue;
        this.enseignant = enseignant;
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
    }

    public UE getUe() {
        return ue;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public int getVolumeCM() {
        return volumeCM;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public int getVolumeTP() {
        return volumeTP;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public void setVolumeCM(int volumeCM) {
        this.volumeCM = volumeCM;
    }

    public void setVolumeTD(int volumeTD) {
        this.volumeTD = volumeTD;
    }

    public void setVolumeTP(int volumeTP) {
        this.volumeTP = volumeTP;
    }
}
