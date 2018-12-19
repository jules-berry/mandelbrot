package Suites;

/**
 * Représentation d'un nombre complexe
 */
public class Complexe {

    /**
     * Partie Réelle
     */
    public double re;

    /**
     * Partie imaginère
     */
    public double im;

    public Complexe(){
        re=0;
        im=0;
    }

    public Complexe(double r, double i){
        re=r;
        im=i;
    }

    public static Complexe add(Complexe z1, Complexe z2){
        Complexe z = new Complexe();
        z.re = z1.re + z2.re;
        z.im = z1.im + z2.im;
        return z;
    }

    public static Complexe mult(Complexe z1, Complexe z2){
        Complexe z = new Complexe();
        z.re = z1.re*z2.re - z1.im*z2.im;
        z.im = z1.re*z2.im + z1.im*z2.re;
        return z;
    }

    public double norme(){
        return Math.sqrt(re*re + im*im);
    }

    public String toString(){
        return Double.toString(re) + "+"+Double.toString(im)+"i";
    }

}
