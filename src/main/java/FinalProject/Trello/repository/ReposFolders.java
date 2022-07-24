package FinalProject.Trello.repository;

import FinalProject.Trello.model.Folders;
import FinalProject.Trello.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ReposFolders extends JpaRepository<Folders, Long> {
}
