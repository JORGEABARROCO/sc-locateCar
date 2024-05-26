@Autowired
private RentService rentService;

@PostMapping
public ResponseEntity<?> rentCar(@Valid @RequestBody RentRequest rentRequest,
                                 @AuthenticationPrincipal UserDetails userDetails) {
    if (!carService.checkIfCarIsAvailable(rentRequest.getCarId())) {
        return ResponseEntity.badRequest().body(new MessageResponse("This car is already rented"));
    }

    Rent rent = rentService.rentCar(
            rentRequest.getCarId(), Long.parseLong(userDetails.getUsername()), rentRequest.getRentTime());
    return ResponseEntity.ok(rent);
}
        Rent rent = rentService.rentCar(
                rentRequest.getCarId(), Long.parseLong(userDetails.getUsername()), rentRequest.getRentTime());
        return ResponseEntity.ok(rent);
    }
}
