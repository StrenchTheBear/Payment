package com.usmp.entity;

import javax.persistence.*;

@Entity
@Table(name = "perfil")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Customer customer;

    @Column(name = "perfil")
    private String profile;

    public Profile() {
    }

    public Profile(Customer customer) {
        this.customer = customer;
        this.profile = "USUARIO";
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public String getProfile() { return profile; }
    public void setProfile(String profile) { this.profile = profile; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Profile{");
        sb.append("id=").append(id);
        sb.append(", customer=").append(customer);
        sb.append(", profile='").append(profile).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
