package br.com.poch2jpa.repository.manytomany;

import br.com.poch2jpa.model.manytomany.Segment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SegmentRepository extends JpaRepository<Segment, Long> {

    @Query("SELECT segment FROM Segment           segment " +
            " JOIN FETCH segment.components       component " +
            " JOIN FETCH component.compositions   composition " +
            "WHERE segment.description      IN ( :segmentDescription )" +
            "  AND component.description    IN ( :componentDescription )" +
            "  AND composition.description  IN ( :compositionDescription )")
    Set<Segment> findSegment(@Param("segmentDescription") List<String> segmentDescription,
                             @Param("componentDescription") List<String> componentDescription,
                             @Param("compositionDescription") List<String> compositionDescription);


}
