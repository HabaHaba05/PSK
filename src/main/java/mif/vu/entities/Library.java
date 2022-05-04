package mif.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "LIBRARY")
@NamedQueries({
        @NamedQuery(name = "Library.findAll", query = "select a from Library as a")
})
@EqualsAndHashCode
public class Library implements Serializable {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name="NAME")
    private String name;

    @NotNull
    @Column(name="ADDRESS")
    private String address;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "library")
    private Set<Book> books;

    public Library(Integer id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
