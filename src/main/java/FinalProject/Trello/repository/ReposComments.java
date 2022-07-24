package FinalProject.Trello.repository;

import FinalProject.Trello.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ReposComments extends JpaRepository<Comments, Long> {
}
