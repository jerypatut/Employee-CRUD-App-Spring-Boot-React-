package fulstack.springboot.api_crud.jar.controller;

import fulstack.springboot.api_crud.jar.dto.Response.ApiResponse;
import fulstack.springboot.api_crud.jar.dto.KaryawanDto;
import fulstack.springboot.api_crud.jar.entity.Karyawan;
import fulstack.springboot.api_crud.jar.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/karyawan")
public class KaryawanController {

    private final KaryawanService karyawanService;

    @Autowired
    public KaryawanController(KaryawanService karyawanService) {
        this.karyawanService = karyawanService;
    }

    // Membuat karyawan baru
    @PostMapping
    public ResponseEntity<ApiResponse<KaryawanDto>> createKaryawan(@RequestBody KaryawanDto karyawanDto) {
        KaryawanDto savedKaryawan = karyawanService.createKaryawan(karyawanDto);
        ApiResponse<KaryawanDto> response = new ApiResponse<>("success", "Data berhasil disimpan", savedKaryawan);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Mendapatkan karyawan berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<KaryawanDto>> getKaryawanById(@PathVariable("id") Long karyawanId) {
        KaryawanDto karyawanDto = karyawanService.getKaryawanByid(karyawanId);
        ApiResponse<KaryawanDto> response = new ApiResponse<>("success", "Data berhasil diambil", karyawanDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Mendapatkan semua karyawan
    @GetMapping
    public ResponseEntity<ApiResponse<List<KaryawanDto>>> getAllKaryawan() {
        List<KaryawanDto> karyawanList = karyawanService.getAllKaryawan();
        ApiResponse<List<KaryawanDto>> response = new ApiResponse<>("success", "Data berhasil diambil", karyawanList);
        return ResponseEntity.ok(response);
    }

    // Mengupdate karyawan yang sudah ada
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<KaryawanDto>> updateKaryawan(
            @PathVariable("id") Long karyawanId,
            @RequestBody Karyawan updatedKaryawan) {
        KaryawanDto karyawanDto = karyawanService.updateKaryawan(karyawanId, updatedKaryawan);
        ApiResponse<KaryawanDto> response = new ApiResponse<>("success", "Data berhasil diperbarui", karyawanDto);
        return ResponseEntity.ok(response);
    }

    // Delete Karyawan Rest Api
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteKaryawan(@PathVariable("id") Long karyawanId) {
        karyawanService.deleteKaryawan(karyawanId);
        ApiResponse<String> response = new ApiResponse<>("success", "Karyawan berhasil dihapus", "Karyawan dengan ID " + karyawanId + " telah dihapus.");
        return ResponseEntity.ok(response);
    }
}
