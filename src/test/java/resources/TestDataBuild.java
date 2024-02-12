package resources;

import pojo.AddPlacePage;
import pojo.LocationPage;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlacePage addPlacePayload(String name, String language, String address) {

        AddPlacePage p = new AddPlacePage();
        p.setAccuracy(50);
        p.setAddress(address);
        p.setLanguage(language);
        p.setPhone_number("(+91) 983 893 3937");
        p.setName(name);
        p.setWebsite("https://rahulshettyacademy.com");

        List<String> myList = new ArrayList<>();
        myList.add("shoe park");
        myList.add("shop");
        p.setTypes(myList);

        LocationPage l = new LocationPage();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        return p;
    }
}
