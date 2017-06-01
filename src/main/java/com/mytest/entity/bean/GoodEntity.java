package com.mytest.entity.bean;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2016-07-01.
 */
@Entity
@Table(name = "good", schema = "", catalog = "jdy")
public class GoodEntity {
    private int id;
    private String goodName;
    private BigDecimal goodPrice;
    private String goodDescribe;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "good_name")
    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    @Basic
    @Column(name = "good_price")
    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }

    @Basic
    @Column(name = "good_describe")
    public String getGoodDescribe() {
        return goodDescribe;
    }

    public void setGoodDescribe(String goodDescribe) {
        this.goodDescribe = goodDescribe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodEntity that = (GoodEntity) o;

        if (id != that.id) return false;
        if (goodName != null ? !goodName.equals(that.goodName) : that.goodName != null) return false;
        if (goodPrice != null ? !goodPrice.equals(that.goodPrice) : that.goodPrice != null) return false;
        if (goodDescribe != null ? !goodDescribe.equals(that.goodDescribe) : that.goodDescribe != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (goodName != null ? goodName.hashCode() : 0);
        result = 31 * result + (goodPrice != null ? goodPrice.hashCode() : 0);
        result = 31 * result + (goodDescribe != null ? goodDescribe.hashCode() : 0);
        return result;
    }
}
