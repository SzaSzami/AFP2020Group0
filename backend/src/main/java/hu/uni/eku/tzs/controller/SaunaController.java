package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.controller.dto.GuestEnterRequestDto;
import hu.uni.eku.tzs.controller.dto.SaunaDto;
import hu.uni.eku.tzs.service.SaunaService;
import hu.uni.eku.tzs.service.exceptions.GuestTooYoungException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/sauna")
@RequiredArgsConstructor
@Api(tags = "Sauna")
@Slf4j
public class SaunaController {

    private final SaunaService service;

    @PostMapping("/enter")
    @ApiOperation(value = "Enter")
    public void enter(
            @RequestBody
                    GuestEnterRequestDto request
    ){
        log.info("Enter information:  {}, {}, {}",request.getName(),request.getAge(),request.getDate());
        try {
            service.Enter(request.getName(), request.getAge(), request.getDate());
        } catch (GuestTooYoungException e) {
            log.info("Guest {}, {} can not use the sauna! Message: {}", request.getName(),request.getAge(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Guests")
    public Collection<SaunaDto> query(){
        return service.readAll().stream().map(model ->
                SaunaDto.builder()
                        .name(model.getName())
                        .age(model.getAge())
                        .Date(model.getDate())
                        .build()
        ).collect(Collectors.toList());
    }
}
