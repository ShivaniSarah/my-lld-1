package comPackage.lld6Improved.lld6;

public class Package {
    protected String packId;
    protected Type type;
    protected Size size;
    protected int  weight;

    public Package(String args[]) {
        this.packId = args[0];
        this.type = Type.getName(args[1]);
        this.size = new Size(Integer.parseInt(args[2]),Integer.parseInt(args[3]),Integer.parseInt(args[4]));
        this.weight = Integer.parseInt(args[5]);
    }


    public double getSpace() {
        return size.getVolume()*type.getVolumeMultiplier();
    }
    public double getTransportationCharge(){
        return size.getVolume()*type.getTransportMultiplier();
    }
    public double getServiceCharge(int distance){
        return size.getVolume()*type.getServiceCostMultiplier() + distance + type.getServiceCostMultiplier();
    }
    public double getTotal(int distance){
        return getTransportationCharge() + getServiceCharge(distance);
    }
}
