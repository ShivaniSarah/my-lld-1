package comPackage.lld6.impl;

import comPackage.lld6.service.PackageType;
import lombok.AllArgsConstructor;


public class Standard extends PackageType {

    public Standard(String packId,String packType, String weight, String height, String length, String width) {
        super(packId,packType,weight,height,length,width);

    }

    @Override
    public double getSpace() {
        return 1.2*getVolume();
    }

    @Override
    public double getTransportationCharge() {
        return 0.05*getVolume();
    }

    @Override
    public double getServiceCharge(int distance) {
        return 0.5*distance +0.5*weight;
    }

    @Override
    public double getTotal(int distance) {
        return getTransportationCharge()+getServiceCharge(distance);
    }
}
