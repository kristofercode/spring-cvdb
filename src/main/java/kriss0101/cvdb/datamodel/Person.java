package kriss0101.cvdb.datamodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@AllArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToOne(fetch = FetchType.EAGER)
    private Contact contact;

    @OneToOne(fetch = FetchType.EAGER)
    private Presentation presentation;



}
