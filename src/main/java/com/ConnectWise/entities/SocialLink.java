package com.ConnectWise.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class SocialLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // it will automatically increase value of id...
    private Long id;
    private String link;
    private String title;

    @ManyToOne
    private Contact contact;
}
