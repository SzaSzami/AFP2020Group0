package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.controller.dto.BillDto;
import hu.uni.eku.tzs.controller.dto.BillRequestDto;
import hu.uni.eku.tzs.model.Bill;
import hu.uni.eku.tzs.service.BillService;
import hu.uni.eku.tzs.service.exceptions.BillAlreadyExistsException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bill")
@RequiredArgsConstructor
@Api(tags = "Bills")
@Slf4j
public class BillController {

    private final BillService service;

    @PostMapping("/generate")
    @ApiOperation(value = "Generate")
    public void generate(
            @RequestBody
                    BillRequestDto request
    ){
        log.info("Generating bill ({},{},{},{})",request.getOwner(), request.getUsers(), request.getItems(), request.getEndstamp());
        try {
            service.generate(new Bill(request.getOwner(),request.getUsers(), request.getItems(), request.getEndstamp()));
        } catch (BillAlreadyExistsException e) {
            log.info("Bill ({},{},{},{})  already exists! Message: {}", request.getOwner(),request.getUsers(), request.getItems(), request.getEndstamp(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Bills")
    public Collection<BillDto> query(){
        return service.readAll().stream().map(model ->
                BillDto.builder()
                        .owner(model.getOwner())
                        .users(model.getUsers())
                        .items(model.getItems())
                        .endstamp(model.getEndstamp())
                        .build()
        ).collect(Collectors.toList());
    }

}
