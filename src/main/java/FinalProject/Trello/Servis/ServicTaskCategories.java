package FinalProject.Trello.Servis;

import FinalProject.Trello.model.TaskCategories;

public interface ServicTaskCategories {
    TaskCategories getCategoryById(Long id);
    void deleteById(Long id);
}
