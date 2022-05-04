package mif.vu.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "AUTHOR")
@NamedQueries({
        @NamedQuery(name = "Author.findAll", query = "select a from Author as a")
})
@EqualsAndHashCode
public class Author implements Serializable {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name="NAME")
    private String name;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "authors")
    @JsonIgnore
    private List<Book> books = new ArrayList<>();
}
