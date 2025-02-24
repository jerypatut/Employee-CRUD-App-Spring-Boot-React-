package fulstack.springboot.api_crud.jar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/// Menghindari Over-fetching atau Under-fetching Data->ini berguna supay data yang tersusun di databnase itu kit aambil yang perlunya saja,,seperti kita tidak perlu menggunakan semua data yangt ada di database gituh
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KaryawanDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
