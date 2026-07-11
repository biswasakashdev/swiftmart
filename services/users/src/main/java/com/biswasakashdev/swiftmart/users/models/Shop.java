package com.biswasakashdev.swiftmart.users.models;

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
@Table("shops")
public class Shop {

    @Id
    private String id;
    @Column("shop_name")
    private String name;
    @Column("owner_id")
    private String ownerId;
    @Column("created_on")
    private LocalDate createdOn;

}
