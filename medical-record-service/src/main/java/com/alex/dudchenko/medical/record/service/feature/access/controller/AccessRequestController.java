package com.alex.dudchenko.medical.record.service.feature.access.controller;


import com.alex.dudchenko.medical.record.service.feature.access.model.AccessRequest;
import com.alex.dudchenko.medical.record.service.feature.access.model.dto.AccessRequestDto;
import com.alex.dudchenko.medical.record.service.feature.access.service.AccessRequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/access-requests")
@AllArgsConstructor
public class AccessRequestController {

    private final AccessRequestService accessRequestService;

    @GetMapping("/{id}")
    public AccessRequest getAccessRequest(@PathVariable Long id) {
        return accessRequestService.getAccessRequestById(id);
    }

    @GetMapping(params = {"status", "patientId"})
    public ResponseEntity<List<AccessRequest>> getAccessRequest(@RequestParam String status, @RequestParam Long patientId) {
        return ResponseEntity.ok(accessRequestService.getAccessRequestsByStatusAndPatient(status, patientId));
    }

    @GetMapping(params = {"status", "patientId", "doctorId"})
    public ResponseEntity<List<AccessRequest>> getAccessRequestForPatientAndDoctor(@RequestParam String status, @RequestParam Long patientId, @RequestParam Long doctorId) {
        return ResponseEntity.ok(accessRequestService.getAccessRequestsByStatusAndPatientAndDoctor(status, patientId, doctorId));
    }

    @PostMapping
    public AccessRequest createAccessRequest(@RequestBody AccessRequestDto accessRequest) {
        return accessRequestService.save(accessRequest);
    }

    @PutMapping("/{id}")
    public AccessRequest updateAccessRequest(@RequestBody AccessRequest accessRequest) {
        return accessRequestService.update(accessRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteAccessRequest(@PathVariable Long id) {
        accessRequestService.deleteAccessRequestById(id);
    }
}
