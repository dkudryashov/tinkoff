package ru.dkudryashov.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Dmitry on 04.04.17.
 */
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "APPLICATION")
@XmlRootElement
public class Application implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "dt_created")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date dtCreated;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_ID")
    private Contact contact;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Application that = (Application) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        return dtCreated != null ? dtCreated.equals(that.dtCreated) : that.dtCreated == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (dtCreated != null ? dtCreated.hashCode() : 0);
        return result;
    }
}
