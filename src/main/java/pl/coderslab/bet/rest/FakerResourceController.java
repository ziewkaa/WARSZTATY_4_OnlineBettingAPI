package pl.coderslab.bet.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.bet.service.FakerService;

@RestController
@RequestMapping("/api")
public class FakerResourceController {

    @Autowired
    private FakerService fakerService;

    @GetMapping("/fake-users")
    public String users() {
        return fakerService.getUsers().toString();
    }

    @GetMapping("/fake-teams")
    public String teams() {
        return fakerService.getTeams().toString();
    }

    @GetMapping("/fake-cities")
    public String cities() {
        return fakerService.getCities().toString();
    }

    @GetMapping("/fake-leagues")
    public String leagues() {
        return fakerService.getLeagues().toString();
    }


    @GetMapping("/fake-results")
    public String results() {
        return fakerService.getResults().toString();
    }

    @GetMapping("/fake-sports")
    public String sports() {
        return fakerService.getSports().toString();
    }

    @GetMapping("/fake-countries")
    public String countries() {
        return fakerService.getCountries().toString();
    }

}
