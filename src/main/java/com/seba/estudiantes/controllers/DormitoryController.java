package com.seba.estudiantes.controllers;

import com.seba.estudiantes.models.Contact;
import com.seba.estudiantes.models.Dormitory;
import com.seba.estudiantes.models.Student;
import com.seba.estudiantes.services.ApiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DormitoryController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/dorms/new")
    public String newDormitorio(@ModelAttribute("dormitorio")Dormitory dormitory){
        return "newDormitorio.jsp";
    }

    @PostMapping("/dorms/new")
    public String crearDormitorio(@Valid @ModelAttribute("dormitorio") Dormitory dormitory, BindingResult result){
        if (result.hasErrors()){
            return "newDormitorio.jsp";
        }else {
            apiService.createDormitory(dormitory);
            return "redirect:/";
        }
    }
    @GetMapping("/dorms/{id}")
    public String verDormitorio(@ModelAttribute("dormitory") Student student, @PathVariable("id") Long id, Model model){
        model.addAttribute("todosStudents", apiService.obtenerNoDormitory());
        model.addAttribute("idDormitory", apiService.findDormitory(id));
        return "verDormitorio.jsp";
    }

    @PostMapping("/dorms/{id}")
    public String enlazarDormitorio(@Valid @ModelAttribute("dormitory") Student student,
                                    BindingResult result, @PathVariable("id")Long id){
        if (result.hasErrors()){
            return "verDormitorio.jsp";
        }else{
            Dormitory dormitory = apiService.findDormitory(id);
            apiService.updateStudent(student,dormitory);
            return "redirect:/dorms/" + id;
        }
    }

}
