package sv.edu.udb.www.vivero_naturalworld.controller;

import sv.edu.udb.www.vivero_naturalworld.entities.Productos;
import sv.edu.udb.www.vivero_naturalworld.model.ProductosModel;
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
@RequestMapping("vendedor/producto")
public class ProductosController {

    CategoriasModel categoriasModel = new CategoriasModel();
    ProductosModel productosModel = new ProductosModel();

    @RequestMapping(value = "list", method = GET)

    public String listarProductos(ModelMap modelMap){

        //Pasando la lista de productos hacia la vista
        modelMap.addAttribute("listaProductos", productosModel.listarProductos());

    //Redireccionando a la página de listarProductos.jsp
        return "vendedor/listarProductos";
    }



    //Este método permite mostrar el formulario para el registro del producto
    @RequestMapping(value = "create", method = GET)

    public String nuevoProducto(Model model){

        //Se le pasa a la vista el objecto que debe llenarse desde el formuario
        model.addAttribute("producto", new Productos());

        // Obtener la lista de categorias y pasarla al modelo
        model.addAttribute("categorias", categoriasModel.listarCategorias());

        return "vendedor/nuevoProducto";

    }



    //Este método se ejecuta al enviar el formulario desde la vista
    @RequestMapping(value = "create", method = POST)

    public String insertarEditorial(@ModelAttribute("producto") Productos producto, Model model, RedirectAttributes atributos) {

        if(productosModel.insertarProducto(producto)>0){

            //Si se insertó, se pasa el mensaje de éxito
            atributos.addFlashAttribute("exito","Producto registrado exitosamente");

            //Redirección en el cliente hacia el método listarProductos()
            return "redirect:/vendedor/producto/list";
        }
        else {

            //Sino se insertó regresamos al formulario de ingreso
            model.addAttribute("producto",producto);

            // Obtener la lista de categorias y pasarla al modelo
            model.addAttribute("categorias", categoriasModel.listarCategorias());

            return "vendedor/nuevoProducto";
        }
    }



    //Este método llenará el formulario de edición con los datos del producto
    //El código del producto a editar se recibe por la URL
    @RequestMapping(value = "edit/{codigo}", method = GET)

    public String obtenerProducto(@PathVariable("codigo") String codigo, Model model){

        model.addAttribute("producto", productosModel.obtenerProducto(codigo));

        // Obtener la lista de categorias y pasarla al modelo
        model.addAttribute("categorias", categoriasModel.listarCategorias());

        return "vendedor/editarProducto";
    }



    //Este método se ejecuta al enviar el formulario de edición
    @RequestMapping(value = "edit/{codigo}", method = POST)

    public String modificarProducto(Productos producto, Model model, RedirectAttributes atributos) {

        if(productosModel.modificarProducto(producto)>0){

            atributos.addFlashAttribute("exito","Producto modificado exitosamente");
            return "redirect:/vendedor/producto/list";
        }
        else {
            model.addAttribute("prodcuto",producto);
            return "vendedor/editarProducto";
        }
    }



    //El código del producto a eliminar se recibe por la url
    @RequestMapping(value = "delete/{codigo}")

    public String eliminarProducto(@PathVariable("codigo") String codigo, Model model, RedirectAttributes atributos){

        model.addAttribute("producto", productosModel.eliminarProducto(codigo));

        if(productosModel.eliminarProducto(codigo)>0){

            atributos.addFlashAttribute("exito","producto eliminado exitosamente");

        }
        else {

            model.addAttribute("fracaso","no se puede eliminar este producto");

        }
        return "redirect:/vendedor/producto/list";
    }
}

