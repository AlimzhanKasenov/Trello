package FinalProject.Trello.repository;

import FinalProject.Trello.model.TaskCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ReposTaskCategories extends JpaRepository<TaskCategories, Long> {

}
