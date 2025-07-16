package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String plan;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean status;

    @OneToOne
    @JoinColumn(name ="user_id")
     private User user;


}
