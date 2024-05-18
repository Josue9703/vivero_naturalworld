package sv.edu.udb.www.vivero_naturalworld.controller;

import sv.edu.udb.www.vivero_naturalworld.entities.Usuarios;
import sv.edu.udb.www.vivero_naturalworld.model.RolModel;
import sv.edu.udb.www.vivero_naturalworld.model.UsuariosModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("administrador/usuario")

public class UsuarioController {

    UsuariosModel usuariosModel = new UsuariosModel();

    RolModel rolModel = new RolModel();

    @RequestMapping(value = "list", method = GET)

    public String listarUsuarios(ModelMap modelMap){

        //Pasando la lista de usuarios hacia la vista
        modelMap.addAttribute("listaUsuarios", usuariosModel.listarUsuarios());

        //Redireccionando a la página de listarUsuarios.jsp
        return "administrador/usuarios/listarUsuarios";
    }




    //Este método permite mostrar el formulario para el registro del usuario
    @RequestMapping(value = "create", method = GET)

    public String nuevoUsuario(Model model){

        //Se le pasa a la vista el objecto que debe llenarse desde el formuario
        model.addAttribute("usuario", new Usuarios());

        // Obtener la lista de roles y pasarla al modelo
        model.addAttribute("roles", rolModel.listarRoles());

        return "administrador/usuarios/nuevoUsuario";

    }



    //Este método se ejecuta al enviar el formulario desde la vista
    @RequestMapping(value = "create", method = POST)

    public String insertarUsuario(@ModelAttribute("usuario") Usuarios usuario, Model model, RedirectAttributes atributos) {

        if(usuariosModel.insertarUsuario(usuario)>0){

            //Si se insertó, se pasa el mensaje de éxito
            atributos.addFlashAttribute("exito","Usuario registrado exitosamente");

            //Redirección en el cliente hacia el método listarUsuarios()
            return "redirect:/administrador/usuario/list";

        }
        else {
            //Sino se insertó regresamos al formulario de ingreso
            model.addAttribute("usuario",usuario);

            // Obtener la lista de roles y pasarla al modelo
            model.addAttribute("roles", rolModel.listarRoles());

            return "administrador/usuarios/nuevoUsuario";
        }
    }




    //Este método llenará el formulario de edición con los datos del usuario
    //El código del usuario a editar se recibe por la URL
    @RequestMapping(value = "edit/{codigo}", method = GET)

    public String obtenerUsuario(@PathVariable("codigo") String codigo, Model model){

        model.addAttribute("usuario", usuariosModel.obtenerUsuario(codigo));

        // Obtener la lista de categorias y pasarla al modelo
        model.addAttribute("roles", rolModel.listarRoles());

        return "administrador/usuarios/editarUsuario";
    }




    //Este método se ejecuta al enviar el formulario de edición
    @RequestMapping(value = "edit/{codigo}", method = POST)

    public String modificarUsuario(Usuarios usuario, Model model, RedirectAttributes atributos) {

        if(usuariosModel.modificarUsuario(usuario)>0){

            atributos.addFlashAttribute("exito","Usuario modificado exitosamente");

            return "redirect:/administrador/usuario/list";

        }
        else {
            model.addAttribute("usuario",usuario);

            return "administrador/usuarios/editarUsuario";
        }
    }



    //El código del editorial a eliminar se recibe por la url
    @RequestMapping(value = "delete/{codigo}")

    public String eliminarUsuario(@PathVariable("codigo") String codigo, Model model, RedirectAttributes atributos){

        model.addAttribute("usuario", usuariosModel.obtenerUsuario(codigo));

        if(usuariosModel.eliminarUsuario(codigo)>0){

            atributos.addFlashAttribute("exito","Usuario eliminado exitosamente");

        }
        else {

            model.addAttribute("fracaso","no se puede eliminar este usuario");

        }
        return "redirect:/administrador/usuario/list";
    }


}
