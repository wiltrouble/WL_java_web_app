/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 * <p>
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of
 * the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.seedstack.samples.store.domain.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.seedstack.business.domain.BaseAggregateRoot;
import org.seedstack.business.domain.Identity;
import org.seedstack.business.util.inmemory.InMemorySequenceGenerator;

@Entity
public class Product extends BaseAggregateRoot<Long> {
    @Id
    @Identity(generator = InMemorySequenceGenerator.class)
    private Long id;
    private String designation;
    @Column(length = 500)
    private String summary;
    @Column(length = 10000)
    private String details;
    private String picture;
    private Double price;
    private Long categoryId;

    private Product() {
        // A private constructor ensures that the product is created through its
        // factory so the identity generator is invoked just after creation
    }

    @Override
    public Long getId() {
        return id;
    }

    public Product(long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
