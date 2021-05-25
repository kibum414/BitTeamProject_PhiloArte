package shop.parkkibeom.api.art.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.parkkibeom.api.art.domain.PageRequestDTO;
import shop.parkkibeom.api.art.service.ArtServiceImpl;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/arts")
public class ArtController {

    private final ArtServiceImpl artService;

    @GetMapping("/list/{page}")
    public ResponseEntity<List<ArtDto>> list(@PathVariable("page") int page) {
        System.out.println("list()");

        return ResponseEntity.ok(artService.getArtList(new PageRequestDTO(page)).getDtoList());
    }

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody ArtDto artDto) {
        return ResponseEntity.ok(artService.save(artDto));
    }

    @GetMapping("/read/{artId}")
    public ResponseEntity<ArtDto> read(@PathVariable("artId") Long artId) {
        return ResponseEntity.ok(artService.getArtsByArtId(artId));
    }

    @PutMapping("/modify")
    public ResponseEntity<Long> modify(@RequestBody ArtDto artDto) {
        return ResponseEntity.ok(artService.save(artDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Long> delete(@RequestBody ArtDto artDto) {
        return ResponseEntity.ok(artService.delete(artDto));
    }

}
