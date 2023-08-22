// package com.example.demo.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.entities.Region;
// import com.example.demo.handler.Response;
// import com.example.demo.services.RegionService;

// @RestController
// @RequestMapping("api")
// public class RegionRestController {

//     @Autowired
//     private RegionService regionService;

//     @GetMapping("region")
//     public ResponseEntity<Object> get(){
//         return Response.generateResponse( HttpStatus.OK, "All Datas Retrieved", regionService.Get());
//     }

//     @GetMapping("region/{id}")
//     public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
//         return Response.generateResponse(HttpStatus.OK, "Data Retrieved",   regionService.Get(id));
//     }
    
//     // public Region get(@PathVariable(required = true) Integer id){
//     //     return regionService.Get(id);
//     // }

//     @PostMapping("region")
//     public ResponseEntity<Object> save(@RequestBody Region region){
//         regionService.Save(region);
//         return Response.generateResponse(HttpStatus.OK,"Data has been saved");
//     }

//     // public Boolean save(@RequestBody Region region){
//     //     return regionService.Save(region);
//     // }

//     // Jika terpisah
//     // INSERT
//     // localhost:8088/api/region
//     // @PostMapping("region")
//     // public ResponseEntity<Object> post(@RequestBody Region region) {
//     //     Boolean result = regionService.Save(region);
//     //     if(result) {
//     //         return Response.generateResponse(HttpStatus.OK,"data berhasil tersimpan" );
//     //     }
//     //     return Response.generateResponse(HttpStatus.BAD_REQUEST,"data gagal tersimpan");
//     // }

//     // // UPDATE
//     // // localhost:8088/api/region
//     // @PutMapping("region")
//     // public ResponseEntity<Object> put(@RequestBody Region region) {
//     //     Boolean result = regionService.Save(region);
//     //     if(result) {
//     //         return Response.generateResponse(HttpStatus.OK,"data berhasil terupdate");
//     //     }
//     //     return Response.generateResponse(HttpStatus.BAD_REQUEST,"data gagal terupdate");
//     // }


//     @DeleteMapping("region/{id}")
//     public ResponseEntity<Object> put(@PathVariable(required = true) Integer id) {
//         Boolean result = regionService.Delete(id);
//         if(result) {
//             return Response.generateResponse(HttpStatus.OK,"data berhasil terhapus", HttpStatus.OK);
//         }
//         return Response.generateResponse(HttpStatus.BAD_REQUEST, "data gagal terhapus" );
//     }
    
//     // public Boolean delete(@PathVariable(required = true) Integer id){
//     //     return regionService.Delete(id);
//     // }
// }
