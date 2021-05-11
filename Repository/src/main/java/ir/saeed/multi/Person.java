package ir.saeed.multi;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tab_person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fil_id")
    private Long id;

    @Column(name = "first_name", nullable = false, length = 400)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 500)
    private String lastName;

    @Column(name = "nationalcode", nullable = false, length = 10, unique = true)
    private String nationalCode;

}
