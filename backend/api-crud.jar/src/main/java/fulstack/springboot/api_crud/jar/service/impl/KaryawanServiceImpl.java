package fulstack.springboot.api_crud.jar.service.impl;

import fulstack.springboot.api_crud.jar.exception.ResourceNotFoundException;
import fulstack.springboot.api_crud.jar.mapper.KaryawanMapper;
import fulstack.springboot.api_crud.jar.dto.KaryawanDto;
import fulstack.springboot.api_crud.jar.entity.Karyawan;
import fulstack.springboot.api_crud.jar.repository.KaryawanRepository;
import fulstack.springboot.api_crud.jar.service.KaryawanService;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class KaryawanServiceImpl implements KaryawanService {

    private KaryawanRepository karyawanRepository;
    @Override
    public KaryawanDto createKaryawan(KaryawanDto karyawanDto) {
        // Konversi dari DTO ke Entity
        Karyawan karyawan= KaryawanMapper.mapToKaryawan(karyawanDto);
        // Simpan data ke database
        Karyawan savedKaryawan = karyawanRepository.save(karyawan);
        // Konversi dari Entity ke DTO untuk response
        return KaryawanMapper.mapToKaryawanDto(savedKaryawan);
    }

    @Override
    public KaryawanDto getKaryawanByid(Long karyawanId) {
       Karyawan karyawan =  karyawanRepository.findById(karyawanId)
                .orElseThrow(() -> new ResourceNotFoundException("karyawan dengan id tersebut tidak ketemu: " + karyawanId));
        return KaryawanMapper.mapToKaryawanDto(karyawan);
    }

    @Override
    public List<KaryawanDto> getAllKaryawan() {
        List<Karyawan> karyawanList = karyawanRepository.findAll();
        return karyawanList.stream().map((karyawan) -> KaryawanMapper.mapToKaryawanDto(karyawan))
                .collect(Collectors.toList());
    }

    @Override
    public KaryawanDto updateKaryawan(Long karyawanId, Karyawan updatedKaryawan) {
        Karyawan karyawan = karyawanRepository.findById(karyawanId).orElseThrow(
                () -> new ResourceNotFoundException("Karyawan itu tidak ada dengan id tersebut:" + karyawanId)
        );
        karyawan.setFirstName(updatedKaryawan.getFirstName());
        karyawan.setLastName(updatedKaryawan.getLastName());
        karyawan.setEmail(updatedKaryawan.getEmail());

        Karyawan updatedKaryawanObj = karyawanRepository.save(karyawan);

        return KaryawanMapper.mapToKaryawanDto(updatedKaryawanObj);
    }

    @Override
    public void deleteKaryawan(Long karyawanId) {
        Karyawan karyawan = karyawanRepository.findById(karyawanId).orElseThrow(
                () -> new ResourceNotFoundException("Karyawan itu tidak ada dengan id tersebut:" + karyawanId)
        );
        karyawanRepository.deleteById(karyawanId);
    }


}

