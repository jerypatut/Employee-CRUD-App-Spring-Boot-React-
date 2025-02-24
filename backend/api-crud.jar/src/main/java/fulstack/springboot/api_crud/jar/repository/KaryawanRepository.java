package fulstack.springboot.api_crud.jar.repository;

import fulstack.springboot.api_crud.jar.entity.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KaryawanRepository extends JpaRepository <Karyawan,Long> {
}
