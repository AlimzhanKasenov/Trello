package FinalProject.Trello.Servis;

import FinalProject.Trello.model.Folders;

import java.util.List;

public interface ServicFolders {
    public List<Folders> getAllFolders();
    public String addFolder(Folders folders);
    Folders getById(Long id);
    public Folders addNewFolder(Folders folder);
    public Folders addCategoryToFolder(Long folder, Long category);
}
