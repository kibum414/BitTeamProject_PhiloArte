package shop.parkkibeom.api.artist.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private Long artistId;

    @Column(unique = true, nullable = false)
    private String username;

    @Size(min = 8, message = "Minimum Password Length: 8 characters")
    private String password;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "school")
    private String school;

    @Column(name = "department")
    private String department;

    // @ElementCollection(fetch = FetchType.EAGER)
    // List<Role> roles;

}
