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
    @Column("first_name")
    private String firstName;
    @Column("last_name")
    private String lastName;
    @Column("hashed_password")
    private String hashedPassword;
    @Column("created_on")
    private LocalDate createdOn;
    @Column("account_locked")
    private Boolean accountLocked;
    private String avatar;
}
