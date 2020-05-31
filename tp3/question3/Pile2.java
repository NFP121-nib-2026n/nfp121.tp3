package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
         if(taille <=0)
            taille = CAPACITE_PAR_DEFAUT;
           this.stk = new Stack<T>();;
           this.capacite = taille;
    }

    public Pile2(){
        this(0);
    }

    public void empiler(T o) throws PilePleineException{
        if (estPleine())throw new PilePleineException();
        this.stk.push(o);
    }

    public T depiler() throws PileVideException{
        if (estVide()) throw new PileVideException();
        return stk.pop();
    }

    public T sommet() throws PileVideException{
        if(this.estVide()) throw new PileVideException();
        return stk.peek(); 
    }
    
    public boolean estVide() {
        return stk.isEmpty();
    }
    
    public boolean estPleine() {
            return capacite == stk.size() ;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        Stack<T> stk1 = new Stack<T>();
        for (int i = capacite - 1; i >= 0; i--) {
            T helper;
            helper=stk.pop();
            stk1.push(helper);
            sb.append(helper);
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        for (int i = capacite - 1; i >= 0; i--) {
            T helper;
            helper=stk1.pop();
            stk.push(helper);
        }
        return sb.toString();
    }

    public boolean equals(Object o) {
        if(o==null)return false;
        PileI p = (PileI)o;
        if(p instanceof Pile2){
            if(p.taille()==this.taille() && p.capacite() == this.capacite() && p.toString()== this.toString())
            return true;
        }
        return false;
    } 
    
    public int taille() {
        return stk.size();
    }
    
    public int capacite() {
        return capacite;
    }
    
    public int hashCode() {
        return toString().hashCode();
    }
    

    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile

} // Pile2