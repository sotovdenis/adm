package gpb.adminka.controller;

import gpb.adminka.model.Mechanic;
import gpb.adminka.repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/mechanics")
public class MechanicMvcController {

    private final MechanicRepository mechanicRepository;

    @Autowired
    public MechanicMvcController(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

    @GetMapping
    public String getAllMechanics(Model model) {
        Map<Integer, Mechanic> mechanics = mechanicRepository.getMechanics();
        model.addAttribute("mechanics", mechanics.values());
        return "mechanics/list";
    }

    @GetMapping("/{id}")
    public String getMechanicById(@PathVariable int id, Model model) {
        Mechanic mechanic = mechanicRepository.getMechanic(id);
        if (mechanic != null) {
            model.addAttribute("mechanic", mechanic);
            return "mechanics/details";
        } else {
            return "error";
        }
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("mechanic", new Mechanic());
        return "mechanics/create";
    }

    @PostMapping("/create")
    public String createMechanic(@ModelAttribute Mechanic mechanic) {
        mechanicRepository.setMechanic(mechanic);
        return "redirect:/mechanics";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Mechanic mechanic = mechanicRepository.getMechanic(id);
        if (mechanic != null) {
            model.addAttribute("mechanic", mechanic);
            return "mechanics/edit";
        } else {
            return "error";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateMechanic(@PathVariable int id, @ModelAttribute Mechanic updatedMechanic) {
        Mechanic existingMechanic = mechanicRepository.getMechanic(id);
        if (existingMechanic != null) {
            updatedMechanic.setId(id);
            mechanicRepository.setMechanic(updatedMechanic);
            return "redirect:/mechanics";
        } else {
            return "error";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteMechanic(@PathVariable int id) {
        Mechanic mechanic = mechanicRepository.getMechanic(id);
        if (mechanic != null) {
            mechanicRepository.getMechanics().remove(id);
        }
        return "redirect:/mechanics";
    }
}