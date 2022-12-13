package champollion;

import java.util.ArrayList;
import java.util.Date;

public class Enseignant extends Personne {

    private ArrayList<ServicePrevu> serviceprevu = new ArrayList<>();
    private ArrayList<Intervention> intervention = new ArrayList<>();
    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        float serviceTotal = 0;
        for (ServicePrevu service : serviceprevu){
            serviceTotal += service.getVolumeCM()*1.5;
            serviceTotal += service.getVolumeTD();
            serviceTotal += service.getVolumeTP()*0.75;
        }
        return Math.round(serviceTotal);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        float serviceTotalUE = 0;
        for (ServicePrevu service : serviceprevu) {
            if(service.getUe().equals(ue)){
                serviceTotalUE += service.getVolumeCM()*1.5;
                serviceTotalUE += service.getVolumeTD();
                serviceTotalUE += service.getVolumeTP()*0.75;
            }
        }
        return Math.round(serviceTotalUE);
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magistral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        ServicePrevu sp = new ServicePrevu( ue, this, volumeCM, volumeTD, volumeTP);
        serviceprevu.add(sp);
    }

    /** Ajoute une intervention planifiée pour cet enseignant.
     *
     * @param i l'intervention concernée
     */

        public void ajouteIntervention(Intervention i){
            Intervention in = new Intervention(this,i.getType(), i.getSalle(), i.getUe(), i.getDébut(), i.getHeureDébut(), i.getDurée());
            intervention.add(in);
        }
    /** Indique si un enseignant est en sous-effectif.
     *
     * @return booléen indiquant si l'enseignant est en sous-effectif ou non.
     */
        public boolean estEnSousEffectif(){
            if (heuresPrevues() > 192) {
                return false;
            } else {
                return true;
            }
        }
}
