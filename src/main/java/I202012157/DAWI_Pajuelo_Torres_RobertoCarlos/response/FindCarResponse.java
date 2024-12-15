package I202012157.DAWI_Pajuelo_Torres_RobertoCarlos.response;

import I202012157.DAWI_Pajuelo_Torres_RobertoCarlos.dto.CarDetailDto;

public record FindCarResponse(
        String code, String error, CarDetailDto car
) {}
