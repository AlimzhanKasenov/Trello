package FinalProject.Trello.Servis.Imp;

import FinalProject.Trello.Servis.ServicTasks;
import FinalProject.Trello.model.Folders;
import FinalProject.Trello.model.Tasks;
import FinalProject.Trello.repository.ReposComments;
import FinalProject.Trello.repository.ReposFolders;
import FinalProject.Trello.repository.ReposTaskCategories;
import FinalProject.Trello.repository.ReposTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicTasksImp implements ServicTasks {

    @Autowired
    ReposFolders reposFolders;

    @Autowired
    ReposComments reposComments;

    @Autowired
    ReposTaskCategories reposTaskCategories;

    @Autowired
    ReposTasks reposTasks;


    @Override
    public List<Tasks> findAllByFolder(Folders folders) {
        return reposTasks.findAllByFolder(folders);
    }
}
