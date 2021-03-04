package cz.zk.volumetests.controller;

import cz.zk.volumetests.exception.mainException;
import cz.zk.volumetests.service.MainService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@Api(value = "Labs Manipulations")
@RequestMapping("/main")
@Slf4j
public class MainController {

    @Autowired MainService mainService;

    @GetMapping("/")
    public String getHello()  throws mainException {
        return "Ahoj kamaradi, mame vas radi !";
    }

    @GetMapping("/readfile")
    public String readFile(@RequestBody String fileName)  throws mainException {
        return mainService.readFile(fileName);
    }

    @GetMapping("/createfile")
    public String createFile(@RequestBody String fileName)  throws mainException {
        return mainService.createFile(fileName);
    }



}
