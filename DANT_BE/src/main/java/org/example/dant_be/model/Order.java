package org.example.dant_be.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator", parameters = {
            @Parameter(name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy")})
    @Column(name = "id")
    private String id;

    @Size(min = 5, message = "{size.fullName}")
    @Column(name = "full_name")
    private String fullName;

    @Email(message = "{email.email}")
    @NotBlank(message = "{notblank.email}")
    @Column(name = "email")
    private String email;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "birth_day")
    private Date birthDay;

    @NotBlank(message = "{notblank.addressOrder}")
    @Column(name = "address_order")
    private String addressOrder;


    @Column(name = "phone")
    private String phone;


    @Column(name = "zip")
    private String zip;

    @Column(name = "note")
    private String note;

    @Column(name = "status")
    private String status;

    @Column(name = "pay")
    private String pay;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @JsonIgnore
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
}

