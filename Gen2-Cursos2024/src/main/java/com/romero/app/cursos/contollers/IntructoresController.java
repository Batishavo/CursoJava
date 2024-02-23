package com.romero.app.cursos.contollers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.romero.app.cursos.models.Instructor;
import com.romero.app.cursos.services.IServices;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/Instructores")
public class IntructoresController {

	@Autowired
	private IServices<Instructor> instructoresErvice;
	
	
	@GetMapping(value = "/create")
	public String create(Model model) {
		Instructor instuctor = new Instructor();
		model.addAttribute("instructor",instuctor);
		return "Instructores/create";
	}
	
	/*@PostMapping(value = "/insert")
	public String insert(@Valid  @ModelAttribute("instructor")
			Instructor instructor,
			BindingResult result,
			@RequestParam("image") MultipartFile file) throws IOException{
		if(result.hasErrors()) {
			return "Instuctores/create";
		}
		if((instructor.getId()==null)) {
			instructor.setHoras(0D);
		}
		else {
			instructor.setHoras(instructoresErvice.getByID(instructor.getId()).getHoras());
		}
		//codigo para recuperar la imagen del instructor
		StringBuilder fileNames = new StringBuilder();
		Path fileNameAndPath = Paths.get(System.getProperty("user.dir")+"/src/main/resources/static/uploads",file.getOriginalFilename());
		fileNames.append(file.getOriginalFilename());//CU.jpg
		String extencion = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
		if((!extencion.toLowerCase().equals("png"))&& (!extencion.toLowerCase().equals("jpg")) && (!extencion.toLowerCase().equals("jpeg"))) {}
			FieldError error = new FieldError("intructor", "urlFoto", "El archibo debe de esr una imagen valida"+extencion);
			result.addError(error);
			return "Instructores/create";
		}
		Files.write(fileNameAndPath,file.getBytes());
		Instructor.setURLFoto(fileNames.toString());
		
		instructoresService.save(instructor);
		return "redirect:/intructores/listar";
	)*/
	@PostMapping(value = "/insert")
	public String insert(@Valid @ModelAttribute("instructor") Instructor instructor,
	                     BindingResult result,
	                     @RequestParam("image") MultipartFile file) throws IOException {
	    if (result.hasErrors()) {
	        return "Instructores/create";
	    }
	    
	    if (instructor.getId() == null) {
	        instructor.setHoras(0D);
	    } else {
	        instructor.setHoras(instructoresErvice.getByID(instructor.getId()).getHoras());
	    }
	    
	    StringBuilder fileNames = new StringBuilder();
	    Path fileNameAndPath = Paths.get(System.getProperty("user.dir") + "/src/main/resources/static/uploads", file.getOriginalFilename());
	    fileNames.append(file.getOriginalFilename());

	    String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
	    if (!extension.toLowerCase().equals("png") && !extension.toLowerCase().equals("jpg") && !extension.toLowerCase().equals("jpeg")) {
	        FieldError error = new FieldError("instructor", "urlFoto", "El archivo debe ser una imagen válida (" + extension + ")");
	        result.addError(error);
	        return "Instructores/create";
	    }
	    
	    Files.write(fileNameAndPath, file.getBytes());
	    instructor.setUrlFoto(fileNames.toString());

	    instructoresErvice.save(instructor);
	    return "redirect:/instructores/listar";
	}

	
	@GetMapping (value="/listar")
	public String listar(Model model) {
		return "Intructores/index";
	}
	
	@GetMapping(value = "/api/listadoInstructores",produces= {"application/json"})
	public @ResponseBody Map<String,List<Instructor>> apiListar(Model model)throws InterruptedException{
		Thread.sleep(6000);
		Map<String, List<Instructor>>map = new HashMap();
		map.put("data", instructoresErvice.getAll());
		return map;
		
	}
	
	@GetMapping(value = "/edit/{id}")
	public String edit(@PathVariable(value = "id")Long id,Model model) {
		
		Instructor instructor = null;
		
		if(id>0) {
			instructor = instructoresErvice.getByID(id);
			if(instructor == null) {
				return "redirect:/instructores/listar";
			}
		}
		else {
			return "redirect:/instructores/listar";
		}
		model.addAttribute("instructor",instructor);
	
		return "Instructores/create";
	}
	
	@DeleteMapping(value = "/api/delete/{id}",produces = {"application/json"})
	public @ResponseBody Map<String,String> apiDelete(@PathVariable(value = "id") Long id, Model model){
		instructoresErvice.delete(id);
		Map<String,String> resultados = new HashMap<>();
		resultados.put("success", "true");
		resultados.put("message","Instructor eliminado correctamente");
		return resultados;
	}
	
}
