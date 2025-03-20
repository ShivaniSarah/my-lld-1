package comPackage.lld6.impl;

import comPackage.lld6.service.PackageType;
import lombok.AllArgsConstructor;


public class Fragile  extends PackageType {

    public Fragile(String packId,String packType, String weight, String height, String length, String width) {
        super(packId,packType,weight,height,length,width);

    }
    @Override
    public double getSpace() {
        return 1.5*getVolume();
    }

    @Override
    public double getTransportationCharge() {
        return 0.07*getVolume();
    }

    @Override
    public double getServiceCharge(int distance) {
        return distance*0.5 + weight*0.5;
    }

    @Override
    public double getTotal(int distance) {
        return getTransportationCharge()+getServiceCharge(distance);
    }
}
