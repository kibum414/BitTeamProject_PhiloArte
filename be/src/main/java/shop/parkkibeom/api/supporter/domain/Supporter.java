package shop.parkkibeom.api.supporter.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "supporters")
public class Supporter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supporter_id")
    private long supporterId;

    @Column(unique = true, nullable = false)
    private String username;

    @Size(min = 8, message = "Minimum Password Length: 8 characters")
    private String password;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(name = "supporter_email")
    private String supporterEmail;

    @Column(name = "supporter_number")
    private String supporterPhoneNumber;

}

