package test.springdata.sample.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;

import org.datanucleus.api.jpa.annotations.Extension;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@EntityListeners({ PlayerEntityListener.class })
public class Player extends AbstractEntity {

    private String name;

    private String rank;

    public Player() {
    }

    public Player(String name, String rank, Parent parent) {
        super();

        this.name = name;
        this.rank = rank;
        this.parent = parent;
    }

    @Basic
    @Extension(vendorName = "datanucleus", key = "gae.parent-pk", value = "true")
    private String parentKey;

    @ManyToOne
    protected Parent parent;

    @JsonIgnore
    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", rank=" + rank + ", parentKey=" + parentKey
                + ", getId()=" + getId() + "]";
    }
}
