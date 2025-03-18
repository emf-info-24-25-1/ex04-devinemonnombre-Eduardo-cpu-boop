package ihmsimple.ctrl;

import ihmsimple.services.ServiceDevine;
import ihmsimple.views.View;

import static ihmsimple.services.ServiceDevine.NOMBRE_INVALIDE;

import java.awt.Color;

/**
 * Classe représentant le contrôleur de l'application MVC "IhmSimple".
 * 
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 29.10.2023
 * @version 1.0.0
 */
public class Controller {
    /**
     * Le nombre courrant de l'utilisateur.
     */
    private int nombre;

    /**
     * Référence à la vue de l'application.
     */
    private View refView;

    /**
     * Référence au serviceDevine de l'application.
     */
    private ServiceDevine refServiceDevine;

    /**
     * Constructeur du contrôleur. Comme toujours, le travail N°1 consiste à
     * initialiser TOUS nos attributs :-).
     * Pour les références aux serviceDevine et view, vous devez à présent savoir
     * qu’elles valeurs initiales donner. Pour la valeur initiale de l’attribut
     * nombre, utilisez NOMBRE_INVALIDE.
     */
    public Controller() {
        this.nombre = ServiceDevine.NOMBRE_INVALIDE;
        this.refServiceDevine = new ServiceDevine();
        this.refView = new View();
    }

    /**
     * Méthode permettant de démarrer un nouveau jeu.
     * Voir le diagramme de séquence pour l'implémentation de cette méthode.
     */
    public void actionDemarrerNouveauJeu() {
        nombre = refServiceDevine.penserAUnNombre();
        refView.afficherStatus("Devinez !", Color.YELLOW);
    }

    /**
     * Méthode permettant de deviner le nombre pensé par l'utilisateur.
     * Voir le diagramme de séquence pour l'implémentation de cette méthode.
     */
    public void actionDeviner() {
        if (nombre != NOMBRE_INVALIDE) {
            int valeurPropose = refView.lireValeurProposee();

            if (valeurPropose != NOMBRE_INVALIDE) {
                if (valeurPropose < nombre) {
                    refView.afficherStatus("Trop petit !", Color.RED);
                } else if (valeurPropose > nombre) {
                    refView.afficherStatus("Trop grand !", Color.RED);
                } else {
                    refView.afficherStatus("Trouvé !!!", Color.GREEN);
                }
            } else {
                refView.afficherStatus("Entrez un nombre !", Color.YELLOW);
            }
        }
    }

    /**
     * Méthode permettant de démarrer l'application.
     * Voir le diagramme de séquence pour l'implémentation de cette méthode.
     */
    public void start() {
        refView.ihmStart();
        refView.afficherStatus("Jeu terminé !", Color.LIGHT_GRAY);
    }

    /**
     * Setter de la référence à la vue de l'application.
     * 
     * @param refView la nouvelle référence à la vue de l'application
     */
    public void setRefView(View refView) {
        this.refView = refView;
    }

    /**
     * Setter de la référence au serviceDevine de l'application.
     * 
     * @param refServiceDevine la nouvelle référence au serviceDevine de
     *                         l'application
     */
    public void setRefServiceDevine(ServiceDevine refServiceDevine) {
        this.refServiceDevine = refServiceDevine;
    }

    /**
     * Getter de la référence à la vue de l'application.
     * 
     * @return la référence à la vue de l'application
     */
    public View getRefView() {
        return refView;
    }

    /**
     * Getter de la référence au serviceDevine de l'application.
     * 
     * @return la référence au serviceDevine de l'application
     */
    public ServiceDevine getRefServiceDevine() {
        return refServiceDevine;
    }

}
