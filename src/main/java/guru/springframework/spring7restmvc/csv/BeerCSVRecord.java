package guru.springframework.spring7restmvc.csv;

import guru.springframework.spring7restmvc.model.BeerStyle;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerCSVRecord {

    private String beerName;
    private BeerStyle beerStyle;
    private String upc;
    private Integer quantityOnHand;
    private BigDecimal price;
    private String createdDate;
    private String updateDate;

}
