package I202012157.DAWI_Pajuelo_Torres_RobertoCarlos.dto;

import java.util.Date;

public record CarDto(
        Integer carId,
        String make,
        String model,
        String ownerName,
        String licensePlate
) {}