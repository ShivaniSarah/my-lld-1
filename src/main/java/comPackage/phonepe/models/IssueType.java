package comPackage.phonepe.models;

public enum IssueType {
    PAYMENT("Payment Related"),MUTUAL_FUND("Mutual Fund Related"),GOLD("Gold Related"),INSURANCE("Insurance Related");

    private String value;

    IssueType(String value) {
        this.value = value;
    }

    public static IssueType getName(String type){
        for( IssueType t: IssueType.values()){
            if(t.value.equalsIgnoreCase(type)){
                return t;
            }
        }
        throw new IllegalArgumentException("Illegal package IssueType");
    }
}
