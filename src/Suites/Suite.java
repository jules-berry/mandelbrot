package Suites;

public abstract class Suite {

    public Complexe z0;

    public Complexe c;

    public Complexe z;

    public static final int ITER_BORNEE = 100000;

    public abstract Complexe iterer();

    public abstract double bornee();
}
