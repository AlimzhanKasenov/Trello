package FinalProject.Trello.Servis.Imp;

import FinalProject.Trello.Servis.ServicTaskCategories;
import FinalProject.Trello.model.TaskCategories;
import FinalProject.Trello.repository.ReposComments;
import FinalProject.Trello.repository.ReposFolders;
import FinalProject.Trello.repository.ReposTaskCategories;
import FinalProject.Trello.repository.ReposTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicTaskCategoriesImp implements ServicTaskCategories {

    @Autowired
    ReposFolders reposFolders;

    @Autowired
    ReposComments reposComments;

    @Autowired
    ReposTaskCategories reposTaskCategories;

    @Autowired
    ReposTasks reposTasks;

    @Override
    public TaskCategories getCategoryById(Long id){return reposTaskCategories.findById(id).orElse(null);}

}
