package comPackage.lld6Improved.lld6;

public enum Type {
    STANDARD(1.2,0.05,0.02),
    HAZARDOUS(1.25,0.56,0.78),
    FRAGILE(1.4,1.3,1.4);

    static Type getName(String type){
        for( Type t: Type.values()){
            if(t.name().equalsIgnoreCase(type)){
                return t;
            }
        }
        throw new IllegalArgumentException("Illegal package type");
    }

    private double volumeMultiplier;
    private double transportMultiplier;
    private double serviceCostMultiplier;

    Type(double v, double t, double s){
        this.volumeMultiplier =v;
        this.transportMultiplier = t;
        this.serviceCostMultiplier = s;
    }

    public double getVolumeMultiplier() {
        return volumeMultiplier;
    }

    public double getTransportMultiplier() {
        return transportMultiplier;
    }

    public double getServiceCostMultiplier() {
        return serviceCostMultiplier;
    }
}
