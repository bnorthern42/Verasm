package net.northern.verasm.repository;

import java.util.List;
import java.util.Optional;
import net.northern.verasm.domain.Skills;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Skills entity.
 */
@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long> {
    @Query("select skills from Skills skills where skills.user.login = ?#{principal.username}")
    List<Skills> findByUserIsCurrentUser();

    default Optional<Skills> findOneWithEagerRelationships(Long id) {
        return this.findOneWithToOneRelationships(id);
    }

    default List<Skills> findAllWithEagerRelationships() {
        return this.findAllWithToOneRelationships();
    }

    default Page<Skills> findAllWithEagerRelationships(Pageable pageable) {
        return this.findAllWithToOneRelationships(pageable);
    }

    @Query(
        value = "select distinct skills from Skills skills left join fetch skills.user",
        countQuery = "select count(distinct skills) from Skills skills"
    )
    Page<Skills> findAllWithToOneRelationships(Pageable pageable);

    @Query("select distinct skills from Skills skills left join fetch skills.user")
    List<Skills> findAllWithToOneRelationships();

    @Query("select skills from Skills skills left join fetch skills.user where skills.id =:id")
    Optional<Skills> findOneWithToOneRelationships(@Param("id") Long id);
}
