package com.example.socialapi.comments;

import com.example.socialapi.comments.dto.CmtDTO;
import com.example.socialapi.comments.request.CreateCmtReq;
import com.example.socialapi.comments.request.UpdateCmtReq;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@AllArgsConstructor
@Tag(name = "Comment")
public class CmtController {
    private final CmtService service;
    @PostMapping(value = "/create")
    public ResponseEntity<CmtDTO> createCmtEntity(@RequestBody CreateCmtReq req) {
        return ResponseEntity.ok(service.createCmtEntityService(req));
    }
    @PutMapping(value = "/{id}/update")
    public ResponseEntity<CmtDTO> updateCmtEntity(@PathVariable String id, @RequestBody UpdateCmtReq req) {
        return ResponseEntity.ok(service.updateCmtEntityService(id, req));
    }
    @GetMapping(value = "/p/{postId}")
    public ResponseEntity<List<CmtDTO>> fetchAllByPostId(@PathVariable String postId) {
        return ResponseEntity.ok(service.getAllByPostId(new ObjectId(postId)));
    }
    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity<String> deleteEntity(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteCmt(id));
    }
}
