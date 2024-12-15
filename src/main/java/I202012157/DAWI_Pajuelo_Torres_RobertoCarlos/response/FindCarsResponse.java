package I202012157.DAWI_Pajuelo_Torres_RobertoCarlos.response;

import I202012157.DAWI_Pajuelo_Torres_RobertoCarlos.dto.CarDto;

public record FindCarsResponse(
        String code, String error, Iterable<CarDto> cars
) {}
