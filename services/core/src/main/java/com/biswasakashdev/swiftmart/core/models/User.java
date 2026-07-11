package com.biswasakashdev.swiftmart.core.models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table("users")
public class User {
    @Id
    private String id;
    private String email;
    @Column("country_code")
    private String countryCode;
    @Column("contact_number")
    private String contactNumber;
    private String password;
    @Column("first_name")
    private String firstName;
    @Column("last_name")
    private String lastName;
    @Column("created_on")
    private LocalDate createdOn;
    @Column("account_locked")
    private Boolean accountLocked;
}
