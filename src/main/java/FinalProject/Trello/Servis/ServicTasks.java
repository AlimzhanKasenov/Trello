package FinalProject.Trello.Servis;

import FinalProject.Trello.model.Folders;
import FinalProject.Trello.model.Tasks;

import java.util.List;

public interface ServicTasks {
    public List<Tasks> findAllByFolder(Folders folders);
}
