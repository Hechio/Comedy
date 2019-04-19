package com.stevehechio.quotes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProvideData {
    public static HashMap<String, List<String>>getInfo(){
        HashMap<String, List<String>>headerTitle = new HashMap<String, List<String>>();
        List<String>detail1 = new ArrayList<String>();
        detail1.add("This is an app about the quotes by Jalang'o quoted directly from him through radio and stand_up comedy");
        List<String>detail2 = new ArrayList<String>();
        detail2.add("Jalang'o is one of the top Kenyan comedians and actor. he is also a Radio presenter");
        List<String>detail3 = new ArrayList<String>();
        detail3.add("Developed by a tech enthusiast who is also passionate in acting and comedy");
        List<String>detail4 = new ArrayList<String>();
        detail4.add("YouTube Channel at Hechio Arts Ensemble");
        headerTitle.put("Disclaimer",detail1);
        headerTitle.put("About Jalang'o",detail2);
        headerTitle.put("Developer",detail3);
        headerTitle.put("Funny clips Channels",detail4);
    return headerTitle;
    }
}

