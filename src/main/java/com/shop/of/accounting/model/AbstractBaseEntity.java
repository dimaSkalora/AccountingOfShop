package com.shop.of.accounting.model;

import com.shop.of.accounting.HasId;

public abstract class AbstractBaseEntity implements HasId {
    public static final int START_SEQ = 100000;

    protected Integer id;

    public AbstractBaseEntity() {
    }

    protected AbstractBaseEntity(Integer id) {
        this.id = id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Entity %s (%s)", getClass().getName(), id);
    }

}
