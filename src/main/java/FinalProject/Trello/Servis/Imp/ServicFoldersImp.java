package FinalProject.Trello.Servis.Imp;

import FinalProject.Trello.Servis.ServicFolders;
import FinalProject.Trello.Servis.ServicTaskCategories;
import FinalProject.Trello.model.Folders;
import FinalProject.Trello.model.TaskCategories;
import FinalProject.Trello.repository.ReposComments;
import FinalProject.Trello.repository.ReposFolders;
import FinalProject.Trello.repository.ReposTaskCategories;
import FinalProject.Trello.repository.ReposTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicFoldersImp implements ServicFolders {

    @Autowired
    ReposFolders reposFolders;

    @Autowired
    ReposComments reposComments;

    @Autowired
    ReposTaskCategories reposTaskCategories;

    @Autowired
    ReposTasks reposTasks;

    @Override
    public List<Folders> getAllFolders(){
        return reposFolders.findAll();
    }

    @Override
    public String addFolder(Folders folders){
        reposFolders.save(folders);
        return null;
    }

    @Override
    public Folders addCategoryToFolder(Long folderId, Long categoryId) {
        Folders folder = reposFolders.findById(folderId).orElse(null);
        TaskCategories category = ServicTaskCategories.getCategoryById(categoryId);
        if(folder!=null && category!=null){
            List<TaskCategories> categories = folder.getCategories();
            if(categories==null){
                categories = new ArrayList<>();
            }
            categories.add(category);

            folder.setCategories(categories);
            return reposFolders.save(folder);
        }
        return null;
    }

    @Override
    public Folders getById(Long id) {
        return reposFolders.getById(id);
    }

    @Override
    public Folders addNewFolder(Folders folder) {
        if (folder!=null){ return reposFolders.save(folder);}
        return null;
    }
}
