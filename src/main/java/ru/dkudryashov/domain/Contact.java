package ru.dkudryashov.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * Created by Dmitry on 04.04.17.
 */
@Entity
@Table(name = "CONTACT")
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Contact {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @XmlTransient
    @OneToMany(mappedBy = "contact")
    private List<Application> applications;

    public Contact(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

}
