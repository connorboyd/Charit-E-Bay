package com.springapp.mvc.models;

import java.util.List;
import java.util.ArrayList;

public class Charity {

    public List<Posting> getPostings() {
        ArrayList<Posting> temp = new ArrayList<Posting>();
        temp.add(new Posting());
        return temp; // TODO
    }
}
