package repository;

import entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


    @Query("SELECT p FROM Post p WHERE p.slug = ?1")
    Post findBySlug(String slug);

    @Query("SELECT p FROM Post p WHERE p.published <= CURRENT_DATE ORDER BY p.published DESC")
    Page<Post> findBeforeToday(Pageable pageable);

}


