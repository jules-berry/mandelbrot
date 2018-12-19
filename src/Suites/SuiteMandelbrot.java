package Suites;

public class SuiteMandelbrot extends Suite{


    public Complexe z0 = new Complexe();

    public Complexe c;

    public Complexe z;

    public SuiteMandelbrot(Complexe c){
        this.c = c;
        z=z0;
    }

    @Override
    public Complexe iterer() {
        z = Complexe.add(Complexe.mult(z,z),c);
        return null;
    }

    @Override
    public boolean bornee() {
        z = z0;
        for(int i=0; i<500;i++){
            iterer();
            double n = z.norme();
            if(Double.isInfinite(n) || Double.isNaN(n)){
                return false;
            }
        }
        return true;
    }
}
