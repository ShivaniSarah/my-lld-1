package comPackage.lld6.impl;

import comPackage.lld6.service.PackageType;
import lombok.AllArgsConstructor;


public class Hazardous extends PackageType {

    public Hazardous(String packId,String packType, String weight, String height, String length, String width) {
        super(packId,packType,weight,height,length,width);

    }

    @Override
    public double getSpace() {
        return 1.25*getVolume();
    }

    @Override
    public double getTransportationCharge() {
        return 0.06*getVolume();
    }

    @Override
    public double getServiceCharge(int distance) {
        return 0.625*distance +0.625*weight;
    }

    @Override
    public double getTotal(int distance) {
        return getTransportationCharge()+getServiceCharge(distance);
    }
}
