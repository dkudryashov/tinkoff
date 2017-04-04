package ru.dkudryashov.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Dmitry on 04.04.17.
 */
@Entity
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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
}
