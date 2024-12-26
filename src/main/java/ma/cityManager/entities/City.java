package ma.cityManager.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class City {

    private Long idCity;
    private String name;
    private Double population;
    private String region;

}
