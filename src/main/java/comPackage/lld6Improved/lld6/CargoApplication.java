package comPackage.lld6Improved.lld6;


import java.util.*;

public class CargoApplication {

/*
    Calculate totalVolume
    TotalTransportationCost
    TotalServiceCost
    TotalCost
 */

    //[0]packageID, [1]packageType, [2]height, [3]width, [4]length, [5] weight
    public Map<String, Double> getCargoCost(int distance, List<String[]> products) {

        LinkedHashMap<String,Double> cargoCost = new LinkedHashMap<>();

        double totalSpace=0d;
        double transportationCost=0d;
        double serviceCost=0d;
        double totalCost=0d;

        for(String[] args: products){
            Package p = new Package(args);

            totalSpace+=p.getSpace();
            transportationCost+= p.getTransportationCharge();
            serviceCost += p.getServiceCharge(distance);
            totalCost+= p.getTotal(distance);

        }
        cargoCost.put("TotalSpace",totalCost);
        cargoCost.put("TransportationCost",transportationCost);
        cargoCost.put("ServiceCost",serviceCost);
        cargoCost.put("TotalCost",totalCost);

        return cargoCost;

    }

    public static void main(String args[]){
        List<String[]> l = new ArrayList<>();
        l.add(new String[]{"pack_1","Hazardous","24","22","17","27"});
        l.add(new String[]{"pack_2","Fragile","24","22","17","27"});
        l.add(new String[]{"pack_3","Standard","21","26","14","27"});
        l.add(new String[]{"pack_4","Hazardous","24","22","17","27"});
        CargoApplication ca = new CargoApplication();
        Map<String,Double> mp = ca.getCargoCost(25,l);
        System.out.println(mp);
    }
}
