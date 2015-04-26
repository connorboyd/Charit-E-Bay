package com.springapp.mvc.models;


import javax.persistence.*;
import java.util.Date;

@Entity(name = "bids")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private int amount;

    @Basic
    @Column(name = "date_bid")
    private Date dateBid; // TODO Right datatype?

    @ManyToOne
    @JoinColumn(name = "bidder_id")
    private User bidder;

    public Bid() {
    }

    public Date getDateBid() {
        return dateBid;
    }

    public void setDateBid(Date dateBid) {
        this.dateBid = dateBid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isHighestBid() {
        return false; // TODO
    }

    public User getBidder() {
        return bidder;
    }

    public void setBidder(User bidder) {
        this.bidder = bidder;
    }
}
