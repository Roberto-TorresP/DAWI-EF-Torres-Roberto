package I202012157.DAWI_Pajuelo_Torres_RobertoCarlos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import I202012157.DAWI_Pajuelo_Torres_RobertoCarlos.dto.CarDto;
import I202012157.DAWI_Pajuelo_Torres_RobertoCarlos.service.CarManageService;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class CarManageController {

    @Autowired
    CarManageService carManageService;

    @GetMapping("/start")
    public String start(Model model) {
        try {
            List<CarDto> cars = carManageService.getAllCars();
            model.addAttribute("cars", cars);
            model.addAttribute("error", null);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "An error occurred while retrieving the data");
        }
        return "manage";
    }
}

