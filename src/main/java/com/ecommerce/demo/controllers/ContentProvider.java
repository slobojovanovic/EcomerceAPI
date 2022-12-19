package com.ecommerce.demo.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class ContentProvider {
	/*
	@Autowired
	ConsumerService consumerService;
*/
	@RequestMapping("/")
	public @ResponseBody String greeting() {
		return "Hello, World";
	}
	/*
	//GET by Id
    @GetMapping("/")
    public ResponseEntity<List<StoreDto>> getStore() {
        List<StoreDto> getStores = this.consumerService.saveStores();
        return ResponseEntity.ok(getStores);
    }*/
    
}
