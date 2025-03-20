package comPackage.lld7_new;

public enum ExpenseType {
    EQUAL,
    UNEQUAL,
    PERCENTAGE;

    public static ExpenseType getName(String type){
        for(ExpenseType t: ExpenseType.values() ){
            if(t.name().equalsIgnoreCase(type)){
                return t;
            }
        }
        throw new IllegalArgumentException("Illegal expense type");
    }


}
