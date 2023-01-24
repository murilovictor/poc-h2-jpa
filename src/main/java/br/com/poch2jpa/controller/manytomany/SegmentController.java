package br.com.poch2jpa.controller.manytomany;

import br.com.poch2jpa.model.manytomany.Segment;
import br.com.poch2jpa.repository.manytomany.SegmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class SegmentController {

    private final SegmentRepository segmentRepository;

    @GetMapping
    public ResponseEntity<Set<Segment>> findSegments(@RequestParam List<String> segments,
                                                     @RequestParam List<String> components,
                                                     @RequestParam List<String> compositions) {
        Set<Segment> segment = segmentRepository.findSegment(segments, components, compositions);
        return ResponseEntity.ok(segment);
    }

}
