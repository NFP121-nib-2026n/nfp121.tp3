package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;

    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        if(taille <=0)
            taille = CAPACITE_PAR_DEFAUT;
            this.v = new Vector(taille);
        
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())throw new PilePleineException();
        this.v.addElement(o);
    }

    public Object depiler() throws PileVideException {
        if (estVide())throw new PileVideException();
        return v.remove(v.size()-1);
    }

    public Object sommet() throws PileVideException {
        if (estVide())throw new PileVideException();
        return v.get(v.size()-1);
    }

    public int taille() {
        return v.size();
    }

    public int capacite() {
        return v.capacity();
    }

    public boolean estVide() {
        return v.isEmpty();
    }

    public boolean estPleine() {
        return v.size() == v.capacity();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = v.size() - 1; i >= 0; i--) {
            sb.append(v.get(i));
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(Object o) {
        if(o==null)return false;
        PileI p = (PileI)o;
        if(p instanceof Pile3){
            if(p.taille()==this.taille() && p.capacite() == this.capacite() && p.toString().equals(this.toString()))
            return true;
        }
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
