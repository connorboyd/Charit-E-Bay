package com.springapp.mvc.models;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "postings")
public class Posting {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String title;

    @Basic
    private String description;

    @Basic
    private String image;

    @OneToOne(fetch = FetchType.EAGER)
    private Charity charity;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private User donor;

    @OneToMany
    @JoinColumn(name = "posting_id")
    private Set<Bid> bids;

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public User getDonor() {
        return donor;
    }

    public void setDonor(User donor) {
        this.donor = donor;
    }

    public Bid getHighestBid() {
        return new Bid(); // TODO
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Charity getCharity() {
        return charity;
    }

    public void setCharity(Charity charity) {
        this.charity = charity;
    }

    public Bid getCurrentBid() {
        return null; // TODO
    }

    public Long getId() {
        return id;
    }
}
