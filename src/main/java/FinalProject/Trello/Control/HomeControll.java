package FinalProject.Trello.Control;

import FinalProject.Trello.Servis.ServicComments;
import FinalProject.Trello.Servis.ServicFolders;
import FinalProject.Trello.Servis.ServicTaskCategories;
import FinalProject.Trello.Servis.ServicTasks;
import FinalProject.Trello.model.Folders;
import FinalProject.Trello.model.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeControll{

    @Autowired
    ServicFolders servicFolders;

    @Autowired
    ServicComments servicComments;

    @Autowired
    ServicTaskCategories servicTaskCategories;

    @Autowired
    ServicTasks servicTasks;

    @GetMapping(value = "/")
    public String mainPage(Model model){
        List<Folders> list = servicFolders.getAllFolders();
        model.addAttribute("folders", list);
        return "MainPage";
    }

    @PostMapping(value = "/addFolder")
    public String addFolder(@RequestParam(name = "name") String name){
        Folders folders = new Folders();
        folders.setName(name);
        servicFolders.addFolder(folders);
        return("redirect:/");
    }

    @GetMapping(value = "/details/{id}")
    public String details(@PathVariable(name = "id") Long id, Model model){
        Folders folders = servicFolders.getById(id);
        List<Tasks> list = servicTasks.findAllByFolder(folders);
        model.addAttribute("folderrr", folders);
        model.addAttribute("task", list);
        return "/DetailsPage";
    }

    @PostMapping(value = "/addCategory")
    public String addCategory(@RequestParam(name = "id") Long folder_id,
                              @RequestParam(name = "input") Long category_id) {
        Folders folders = servicFolders.addCategoryToFolder(folder_id, category_id);
        if (folders!=null){
            servicFolders.addNewFolder(folders);
            return "redirect:/details/" + folder_id;
        }
        return null;
    }
}
