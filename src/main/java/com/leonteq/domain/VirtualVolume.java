package com.leonteq.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A VirtualVolume.
 */
@Entity
@Table(name = "virtual_volume")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class VirtualVolume implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "wwn")
    private String wwn;

    @Column(name = "lun_id")
    private String lunID;

    @Column(name = "replicated")
    private Boolean replicated;

    @OneToOne
    @JoinColumn(unique = true)
    private Datastore datastore;

    @ManyToOne
    @JsonIgnoreProperties("")
    private StorageArray storagearray;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public VirtualVolume name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWwn() {
        return wwn;
    }

    public VirtualVolume wwn(String wwn) {
        this.wwn = wwn;
        return this;
    }

    public void setWwn(String wwn) {
        this.wwn = wwn;
    }

    public String getLunID() {
        return lunID;
    }

    public VirtualVolume lunID(String lunID) {
        this.lunID = lunID;
        return this;
    }

    public void setLunID(String lunID) {
        this.lunID = lunID;
    }

    public Boolean isReplicated() {
        return replicated;
    }

    public VirtualVolume replicated(Boolean replicated) {
        this.replicated = replicated;
        return this;
    }

    public void setReplicated(Boolean replicated) {
        this.replicated = replicated;
    }

    public Datastore getDatastore() {
        return datastore;
    }

    public VirtualVolume datastore(Datastore datastore) {
        this.datastore = datastore;
        return this;
    }

    public void setDatastore(Datastore datastore) {
        this.datastore = datastore;
    }

    public StorageArray getStoragearray() {
        return storagearray;
    }

    public VirtualVolume storagearray(StorageArray storageArray) {
        this.storagearray = storageArray;
        return this;
    }

    public void setStoragearray(StorageArray storageArray) {
        this.storagearray = storageArray;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VirtualVolume virtualVolume = (VirtualVolume) o;
        if (virtualVolume.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), virtualVolume.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "VirtualVolume{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", wwn='" + getWwn() + "'" +
            ", lunID='" + getLunID() + "'" +
            ", replicated='" + isReplicated() + "'" +
            "}";
    }
}
