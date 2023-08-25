// package com.example.demo.services;

// import org.springframework.beans.factory.annotation.Autowired;

// import com.example.demo.dto.AskRequest;
// import com.example.demo.entities.Travel;

// public class RequestServiceImpl implements RequestService {
//     @Autowired
//     private TravelService travelService;

//     @Autowired
//     private PosttravelService posttravelService;

//     @Override
//     public Boolean ask(AskRequest askRequest) {
//         Travel travel = new Travel();

//         travel.setEmployee(askRequest.getEmployee());
//         //insert travel
//         Boolean resultTravel = travelService.Save(travel);
//         if (resultTravel){
//             Integer travel_id = travelService.
//         }
//         return resultTravel;
//     }
    
// }
