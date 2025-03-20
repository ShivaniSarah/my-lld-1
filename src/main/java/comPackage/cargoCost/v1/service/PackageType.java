package comPackage.lld6.service;

public abstract class PackageType {
    protected String packId;
    protected String type;
    protected int  height;
    protected int length;
    protected int width;
    protected int  weight;

    public PackageType(String packId,String packType, String weight, String height, String length, String width) {
        this.packId = packId;
        this.type = packType;
        this.height= Integer.parseInt(height);
        this.length = Integer.parseInt(length);
        this.width = Integer.parseInt(width);
        this.weight = Integer.parseInt(weight);
    }

    protected int getVolume(){
        return height*width*length;
    }
    public abstract double getSpace();
    public abstract double getTransportationCharge();
    public abstract double getServiceCharge(int distance);
    public abstract double getTotal(int distance);
}
