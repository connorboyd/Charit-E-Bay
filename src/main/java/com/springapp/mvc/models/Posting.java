package com.springapp.mvc.models;

import com.springapp.SessionFactorySingleton;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "donor_id")
    private User donor;

    @OneToMany(fetch = FetchType.EAGER)
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
        Set<Bid> bids = this.getBids();
        Bid maxBid = null;
        int maxAmount = Integer.MIN_VALUE;
        for(Bid b : bids) {
            if(b.getAmount() > maxAmount) {
                maxBid = b;
                maxAmount = b.getAmount();
            }
        }
        return maxBid;
    }

    public User getHighestBidder() {
        Bid highestBid = getHighestBid();
        return (highestBid != null) ? highestBid.getBidder() : null;
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
