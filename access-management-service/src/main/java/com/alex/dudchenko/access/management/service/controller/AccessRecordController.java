package com.alex.dudchenko.access.management.service.controller;

import com.alex.dudchenko.access.management.service.model.AccessRecord;
import com.alex.dudchenko.access.management.service.service.AccessRecordService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accessRecords")
@AllArgsConstructor
public class AccessRecordController {

    private final AccessRecordService accessRecordService;

    @GetMapping("/{id}")
    public AccessRecord getAccessRecord(@PathVariable Long id) {
        return accessRecordService.getAccessRecordById(id);
    }

    @PostMapping
    public AccessRecord createAccessRecord(@RequestBody AccessRecord accessRecord) {
        return accessRecordService.createAccessRecord(accessRecord);
    }

    @DeleteMapping("{id}")
    public void deleteAccessRecord(@PathVariable Long id) {
        accessRecordService.deleteAccessRecordById(id);
    }
}
