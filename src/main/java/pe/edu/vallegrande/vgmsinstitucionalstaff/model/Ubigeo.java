package pe.edu.vallegrande.vgmsinstitucionalstaff.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ubigeos")
public class Ubigeo {

    @Id
    private String id;
    private String ubigeoReniec;
    private String department;
    private String province;
    private String district;

}