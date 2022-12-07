package interactors;

import entities.Realtor;
import java.io.IOException;
import java.util.ArrayList;

public class RealtorSearchInteractor {
    public ArrayList<ArrayList<String>> listRealtors(){
        UserGateway userGateway = new UserGateway();
        ArrayList<Realtor> realtorArrayList = userGateway.getRealtors();
        ArrayList<ArrayList<String>> realtorInfos = new ArrayList<>();

        for (Realtor r: realtorArrayList) {
            ArrayList<String> realtorInfo = new ArrayList<>();
            realtorInfo.add(r.getName());
            realtorInfo.add(r.getContact());
            realtorInfos.add(realtorInfo);
        }
        return realtorInfos;
    }
}
