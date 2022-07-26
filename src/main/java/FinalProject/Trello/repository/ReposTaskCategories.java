package FinalProject.Trello.repository;

import FinalProject.Trello.model.TaskCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ReposTaskCategories extends JpaRepository<TaskCategories, Long> {
    @Query(value = "SELECT COUNT(categories_id) FROM folders_categories WHERE categories_id=?", nativeQuery = true)
    int checkIsCategoryExist(@Param("?") Long id);
}
