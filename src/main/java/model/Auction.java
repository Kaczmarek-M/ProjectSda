package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private AppUser user;

    private Item item;

    private LocalDateTime expirationDate;

    private String title;

    private String description;

    private boolean isAccepted;

    private boolean isSold;

}
