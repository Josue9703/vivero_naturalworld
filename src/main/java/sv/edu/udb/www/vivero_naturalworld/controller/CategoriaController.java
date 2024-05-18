package sv.edu.udb.www.vivero_naturalworld.controller;

import sv.edu.udb.www.vivero_naturalworld.entities.Categorias;
import sv.edu.udb.www.vivero_naturalworld.model.CategoriasModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("administrador/categoria")

public class CategoriaController {

    CategoriasModel categoriasModel = new CategoriasModel();

    @RequestMapping(value = "list", method = GET)
    public String listarCategorias(ModelMap modelMap){

        //Pasando la lista de editoriales hacia la vista
        modelMap.addAttribute("listaCategorias", categoriasModel.listarCategorias());

        //Redireccionando a la página de listarCategorias.jsp
        return "administrador/categorias/listarCategorias";
    }



    //Este método permite mostrar el formulario para el registro de la categoria
    @RequestMapping(value = "create", method = GET)

    public String nuevaCategoria(Model model){

    //Se le pasa a la vista el objecto que debe llenarse desde el formuario
        model.addAttribute("categoria", new Categorias());

        return "administrador/categorias/nuevaCategoria";
    }



    //Este método se ejecuta al enviar el formulario desde la vista
    @RequestMapping(value = "create", method = POST)

    public String insertarCategoria(@ModelAttribute("categoria") Categorias categoria, Model model, RedirectAttributes atributos) {

        if(categoriasModel.insertarCategoria(categoria)>0){

            //Si se insertó, se pasa el mensaje de éxito
            atributos.addFlashAttribute("exito","Categoria registrado exitosamente");

            //Redirección en el cliente hacia el método listarCategorias()
            return "redirect:/administrador/categoria/list";

        }
        else {

            //Sino se insertó regresamos al formulario de ingreso
            model.addAttribute("categoria",categoria);

            return "administrador/categoria/nuevaCategoria";
        }
    }



    //Este método llenará el formulario de edición con los datos de la categoria
    //El código de la categoria a editar se recibe por la URL
    @RequestMapping(value = "edit/{codigo}", method = GET)

    public String obtenerCategoria(@PathVariable("codigo") String codigo, Model model){

        model.addAttribute("categoria", categoriasModel.obtenerCategoria(codigo));
        return "administrador/categorias/editarCategoria";

    }



    //Este método se ejecuta al enviar el formulario de edición
    @RequestMapping(value = "edit/{codigo}", method = POST)

    public String modificarCategoria(Categorias categoria, Model model, RedirectAttributes atributos) {

        if(categoriasModel.modificarCategoria(categoria)>0){

            atributos.addFlashAttribute("exito","Categoria modificado exitosamente");
            return "redirect:/administrador/categoria/list";

        }
        else {

            model.addAttribute("categoria",categoria);
            return "administrador/categorias/editarCategoria";
        }
    }



    //El código de la categoria a eliminar se recibe por la url
    @RequestMapping(value = "delete/{codigo}")
    public String eliminarCategoria(@PathVariable("codigo") String codigo, Model model, RedirectAttributes atributos){

        model.addAttribute("categoria", categoriasModel.obtenerCategoria(codigo));

        if(categoriasModel.eliminarCategoria(codigo)>0){

            atributos.addFlashAttribute("exito","Categoria eliminado exitosamente");

        }
        else {

            model.addAttribute("fracaso","no se puede eliminar este categoria");

        }

        return "redirect:/administrador/categoria/list";
    }
}

