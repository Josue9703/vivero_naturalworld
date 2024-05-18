package sv.edu.udb.www.vivero_naturalworld.controller;

import sv.edu.udb.www.vivero_naturalworld.entities.Rol;
import sv.edu.udb.www.vivero_naturalworld.model.RolModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("administrador/roles")

public class RolController {

    RolModel rolModel = new RolModel();

    @RequestMapping(value = "list", method = GET)

    public String listarRoles(ModelMap modelMap){

        //Pasando la lista de roles hacia la vista
        modelMap.addAttribute("listaRoles", rolModel.listarRoles());

        //Redireccionando a la página de listarRoles.jsp
        return "administrador/roles/listarRoles";

    }

}
