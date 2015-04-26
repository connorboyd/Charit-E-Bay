package com.springapp.mvc.models;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

@Entity(name = "charities")
public class Charity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String name;

    @OneToMany
    @JoinColumn(name = "charity_id")
    private Set<Posting> postings;

    public Set<Posting> getPostings() {
        return postings;
    }

    public void setPostings(Set<Posting> postings) {
        this.postings = postings;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //public List<Posting> getPostings() {
    //    ArrayList<Posting> temp = new ArrayList<Posting>();
    //    temp.add(new Posting());
    //    return temp; // TODO
    //}
}
