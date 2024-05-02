package Resources;

import POJO.Addplace;
import POJO.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public Addplace addPayload() {
        Addplace ap = new Addplace();

//        Set value to the variables
        ap.setAccuracy(90);
        ap.setAddress("21, side layout, cohen 09");
        ap.setLanguage("French-IN");
        ap.setName("Front house");
        ap.setPhone_number("(+91) 988 344 4321");
        ap.setWebsite("http://google.com");
        //created List of string to add it.
        List<String> type = new ArrayList<String>();

        type.add("shoe park");
        type.add("shop");
// pass the list object to set values to list of string variable
        ap.setTypes(type);
        // created object for subclass of location (nested json)
        Location l = new Location();
        l.setLat(56.383494);
        l.setLng(13.427362);
//send the object to main class set variable
        ap.setLocation(l);

        return ap;

    }
}
