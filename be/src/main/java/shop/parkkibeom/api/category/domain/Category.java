package shop.parkkibeom.api.category.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private long categoryId;

    @Column
    private long name;
}
