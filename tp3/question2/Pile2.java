package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        if(taille <=0)
            taille = CAPACITE_PAR_DEFAUT;
           this.stk = new Stack<Object>();;
           this.capacite = taille;
        }
    

    // constructeur fourni
    public Pile2() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())throw new PilePleineException();
        this.stk.push(o);
    }

    public Object depiler() throws PileVideException {
        if (estVide()) throw new PileVideException();
        return stk.pop();
    }

    public Object sommet() throws PileVideException {
        if(this.estVide()) throw new PileVideException();
        return stk.peek(); 
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return stk.isEmpty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
            return capacite == stk.size() ;
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        Stack<Object> stk1 = new Stack<Object>();
        for (int i = this.taille() - 1; i >= 0; i--) {
            Object helper = new Object();
            helper=stk.pop();
            stk1.push(helper);
            sb.append(helper);
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        for (int i = stk1.size() - 1; i >= 0; i--) {
            Object helper = new Object();
            helper=stk1.pop();
            stk.push(helper);
        }
        return sb.toString();
    }

    public boolean equals(Object o) {
        if(o==null)return false;
        PileI p = (PileI)o;
        if(p instanceof PileI){
            if(p.taille()==this.taille() && p.capacite() == this.capacite() && p.toString().equals(this.toString()))
            return true;
        }
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        return stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        return this.capacite;
    }

} // Pile2.java
