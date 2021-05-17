package shop.parkkibeom.api.art.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.parkkibeom.api.art.domain.Art;
import shop.parkkibeom.api.art.domain.ArtDto;
import shop.parkkibeom.api.art.service.ArtServiceImpl;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/arts")
public class ArtController {

    private final ArtServiceImpl artService;
    private final ModelMapper modelMapper;

    @GetMapping("/list")
    public ResponseEntity<List<Art>> list() {
        return ResponseEntity.ok(artService.findAll());
    }

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody ArtDto art) {
        System.out.println(art.getTitle());
        System.out.println("art : " + modelMapper.map(art, Art.class).getTitle());
        return ResponseEntity.ok(artService.save(modelMapper.map(art, Art.class)));
    }

    @GetMapping("/read")
    public ResponseEntity<Optional<Art>> read(@RequestBody ArtDto art) {
        return ResponseEntity.ok(artService.findById(modelMapper.map(art, Art.class).getArtId()));
    }

    @PutMapping("/modify")
    public ResponseEntity<Long> modify(@RequestBody ArtDto art) {
        return ResponseEntity.ok(artService.save(modelMapper.map(art, Art.class)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Long> delete(@RequestBody ArtDto art) {
        return ResponseEntity.ok(artService.delete(modelMapper.map(art, Art.class)));
    }
}
