package pe.edu.vallegrande.vgmsinstitucionalstaff.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "institucional-staff")
public class InstitucionalStaff {

    @Id
    private String id_institucional_staff;
    private String father_lastname;
    private String mother_lastname;
    private String name;
    private LocalDate birthdate;
    private String document_type;
    private String document_number;
    private String sex;
    private String country;
    @DocumentReference(collection = "ubigeos")
    private Ubigeo ubigeo;
    private String email;
    private String phone;
    private String civil_status;
    private String instruction_grade;
    private String disability_type;
    private String disability;
    private String work_condition;
    private String occupation;
    private String native_language;
    private String state = "A"; //Estado por defecto "Activo"
    private String address;

}
