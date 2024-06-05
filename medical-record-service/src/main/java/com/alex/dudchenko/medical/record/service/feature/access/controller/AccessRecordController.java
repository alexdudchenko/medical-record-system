package com.alex.dudchenko.medical.record.service.feature.access.controller;

import com.alex.dudchenko.medical.record.service.feature.access.model.AccessRecord;
import com.alex.dudchenko.medical.record.service.feature.access.model.dto.AccessRecordDto;
import com.alex.dudchenko.medical.record.service.feature.access.service.AccessRecordService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/access-records")
@AllArgsConstructor
public class AccessRecordController {

    private final AccessRecordService accessRecordService;

    @GetMapping("/{id}")
    public AccessRecord getAccessRecord(@PathVariable Long id) {
        return accessRecordService.getAccessRecordById(id);
    }

    @GetMapping(params = {"patientId", "doctorId"})
    public ResponseEntity<List<AccessRecord>> getAccessRecordsByPatientAndDoctor(@RequestParam Long patientId, @RequestParam Long doctorId) {
        return ResponseEntity.ok(accessRecordService.getAccessRecordsByPatientAndDoctor(patientId, doctorId));
    }

    @GetMapping(params = {"patientId"})
    public ResponseEntity<List<AccessRecord>> getAccessRecordsByPatientId(@RequestParam Long patientId) {
        return ResponseEntity.ok(accessRecordService.getAccessRecordsByPatient(patientId));
    }

    @PostMapping
    public AccessRecord createAccessRecord(@RequestBody AccessRecordDto accessRecord) {
        return accessRecordService.createAccessRecord(accessRecord);
    }

    @DeleteMapping("{id}")
    public void deleteAccessRecord(@PathVariable Long id) {
        accessRecordService.deleteAccessRecordById(id);
    }
}
