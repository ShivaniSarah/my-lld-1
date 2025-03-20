package comPackage.lld6;

public enum Type {
    STANDARD,
    HAZARDOUS,
    FRAGILE;

    static Type getName(String type){
        for( Type t: Type.values()){
            if(t.name().equalsIgnoreCase(type)){
                return t;
            }
        }
        throw new IllegalArgumentException("Illegal package type");
    }
}
