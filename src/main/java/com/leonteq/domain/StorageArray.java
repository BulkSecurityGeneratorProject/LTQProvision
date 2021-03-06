package com.leonteq.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A StorageArray.
 */
@Entity
@Table(name = "storage_array")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class StorageArray implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "ip_address", nullable = false)
    private String ipAddress;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "jhi_password")
    private String password;

    @ManyToOne
    @JsonIgnoreProperties("")
    private PhysicalDatacenter physicaldatacenter;

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

    public StorageArray name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public StorageArray ipAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserName() {
        return userName;
    }

    public StorageArray userName(String userName) {
        this.userName = userName;
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public StorageArray password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PhysicalDatacenter getPhysicaldatacenter() {
        return physicaldatacenter;
    }

    public StorageArray physicaldatacenter(PhysicalDatacenter physicalDatacenter) {
        this.physicaldatacenter = physicalDatacenter;
        return this;
    }

    public void setPhysicaldatacenter(PhysicalDatacenter physicalDatacenter) {
        this.physicaldatacenter = physicalDatacenter;
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
        StorageArray storageArray = (StorageArray) o;
        if (storageArray.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), storageArray.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StorageArray{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", ipAddress='" + getIpAddress() + "'" +
            ", userName='" + getUserName() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
}
