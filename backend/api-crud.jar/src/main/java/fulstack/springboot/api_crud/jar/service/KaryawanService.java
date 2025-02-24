package fulstack.springboot.api_crud.jar.service;

import fulstack.springboot.api_crud.jar.dto.KaryawanDto;
import fulstack.springboot.api_crud.jar.entity.Karyawan;
import java.util.List;
public interface KaryawanService {
    KaryawanDto createKaryawan(KaryawanDto karyawanDto);

    KaryawanDto  getKaryawanByid(Long karyawanId);

    List<KaryawanDto> getAllKaryawan();

    KaryawanDto updateKaryawan (Long karyawanId, Karyawan updatedKaryawan );

    void deleteKaryawan(Long  karyawanId);
}
