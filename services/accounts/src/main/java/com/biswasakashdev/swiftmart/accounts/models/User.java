package com.biswasakashdev.swiftmart.accounts.models;


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
@ToString
public class User {
    @Id
    private String id;
    private String email;
    @Column("country_code")
    private String countryCode;
    private String phone;
    private String password;
    @Column("full_name")
    private String name;
    @Column("created_on")
    private LocalDate createdOn;
    @Column("account_locked")
    private Boolean accountLocked;
    private String avatar;
}
