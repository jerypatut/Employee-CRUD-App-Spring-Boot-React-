package fulstack.springboot.api_crud.jar.mapper;

import fulstack.springboot.api_crud.jar.dto.KaryawanDto;
import fulstack.springboot.api_crud.jar.entity.Karyawan;

public class KaryawanMapper {
    public static KaryawanDto mapToKaryawanDto(Karyawan karyawan) {
        return new KaryawanDto(
                karyawan.getId(),
                karyawan.getFirstName(),
                karyawan.getLastName(),
                karyawan.getEmail()
        );
    }
    public static Karyawan mapToKaryawan (KaryawanDto karyawanDto) {
        return new Karyawan(
                karyawanDto.getId(),
                karyawanDto.getFirstName(),
                karyawanDto.getLastName(),
                karyawanDto.getEmail()
        );
    }
}
