package shop.parkkibeom.api.fundItem.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private long itemId;

    @Column
    private String name;

}
