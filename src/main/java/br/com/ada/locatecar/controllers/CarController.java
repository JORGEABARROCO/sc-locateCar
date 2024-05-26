package br.com.ada.locatecar.controllers;

import br.com.ada.locatecar.dtos.CarDto;
import br.com.ada.locatecar.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável por lidar com requisições relacionadas a carros.
 */
@RestController
@RequestMapping("/api/car")
public class CarController {
    /**
     * Injeção de dependência do serviço de carros.
     */
    @Autowired
    private CarService carService;

    /**
     * Retorna a lista de todos os carros.
     * 
     * @return lista de carros
     */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CarDto> getAllCars() {
        // Chamada ao serviço de carros para obter a lista de carros
        return carService.getAllCars();
    }

    /**
     * Retorna um carro específico pelo seu ID.
     * 
     * @param idCar ID do carro
     * @return carro encontrado
     */
    @GetMapping("/{idCar}")
    @ResponseStatus(HttpStatus.OK)
    public CarDto getCarById(@PathVariable String idCar) {
        // Chamada ao serviço de carros para obter o carro pelo ID
        return carService.getCarById(idCar);
    }

    /**
     * Retorna a lista de carros disponíveis.
     * 
     * @return lista de carros disponíveis
     */
    @GetMapping("/available")
    public List<CarDto> getAllAvailableCars() {
        // Chamada ao serviço de carros para obter a lista de carros disponíveis
        return carService.getAllAvailableCars();
    }
}
