package comPackage.lld6;

import comPackage.lld6.impl.Fragile;
import comPackage.lld6.impl.Hazardous;
import comPackage.lld6.impl.Standard;
import comPackage.lld6.service.PackageType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PackageFactory {

    PackageType getPackageType(String packargs[]){
        if( Type.getName(packargs[1]).equals(Type.STANDARD)) return new Standard(packargs[0],packargs[1],packargs[2],packargs[3],packargs[4],packargs[5]);
        else if( Type.getName(packargs[1]).equals(Type.HAZARDOUS)) return new Hazardous(packargs[0],packargs[1],packargs[2],packargs[3],packargs[4],packargs[5]);
        else if( Type.getName(packargs[1]).equals(Type.FRAGILE)) return new Fragile(packargs[0],packargs[1],packargs[2],packargs[3],packargs[4],packargs[5]);
        else throw new IllegalArgumentException("Not a right type");
    }
}
