package ma.alami.spring5recipeapp.domains;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String notes;

    @OneToOne(mappedBy = "notes")
    private Recipe recipe;


}
