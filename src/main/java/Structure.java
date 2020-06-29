public class Structure {
    private final int v;
    private final int u;
    private final int cost;

    public Structure(int v , int u, int cost){
        this.v = v;
        this.u = u;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }
}
