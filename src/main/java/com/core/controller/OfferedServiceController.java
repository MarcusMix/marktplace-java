package com.core.controller;

import com.core.dto.OfferedServiceDTO;
import com.core.dto.ServiceSearchDTO;
import com.core.service.OfferedServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/offered-service")
public class OfferedServiceController {

    @Autowired
    private OfferedServiceService offeredServiceService;

    @GetMapping
    public List<OfferedServiceDTO> findAll() {
        return offeredServiceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferedServiceDTO> findById(@PathVariable Long id) {
        OfferedServiceDTO offeredServiceDTO = offeredServiceService.findById(id);
        return offeredServiceDTO != null
                ? ResponseEntity.ok(offeredServiceDTO)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<OfferedServiceDTO>> searchServices(@RequestBody ServiceSearchDTO searchDTO) {
        List<OfferedServiceDTO> searchResults = offeredServiceService.searchServices(searchDTO);
        return ResponseEntity.ok(searchResults);
    }

    @PostMapping
    public ResponseEntity<OfferedServiceDTO> create(@RequestBody OfferedServiceDTO offeredServiceDTO) {
        OfferedServiceDTO createdOfferedService = offeredServiceService.create(offeredServiceDTO);
        return createdOfferedService != null
                ? ResponseEntity.status(HttpStatus.CREATED).body(createdOfferedService)
                : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfferedServiceDTO> update(@PathVariable Long id,
            @RequestBody OfferedServiceDTO offeredServiceDTO) {
        OfferedServiceDTO updatedOfferedService = offeredServiceService.update(id, offeredServiceDTO);
        return updatedOfferedService != null
                ? ResponseEntity.ok(updatedOfferedService)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        offeredServiceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}