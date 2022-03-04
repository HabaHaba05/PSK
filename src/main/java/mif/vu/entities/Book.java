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
@Table(name="BOOK")
@NamedQueries({
        @NamedQuery(name = "Book.findAll", query = "select a from Book as a")
})
@EqualsAndHashCode
public class Book implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "TITLE")
    private String title;

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    @EqualsAndHashCode.Exclude
    private Library library;

    @ManyToMany
    @JoinTable(
            name = "BOOK_AUTHOR",
            joinColumns = @JoinColumn(name = "BOOK_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID")
    )
    @NotNull
    @EqualsAndHashCode.Exclude
    private Set<Author> authors;
}
