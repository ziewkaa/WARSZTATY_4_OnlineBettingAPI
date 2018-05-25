package pl.coderslab.bet.service;

import com.github.javafaker.Faker;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakerService {

    private ArrayList<JSONObject> users = new ArrayList<>();
    private ArrayList<JSONObject> teams = new ArrayList<>();
    private ArrayList<JSONObject> sports = new ArrayList<>();
    private ArrayList<JSONObject> countries = new ArrayList<>();
    private ArrayList<JSONObject> cities = new ArrayList<>();
    private ArrayList<JSONObject> leagues = new ArrayList<>();
    private ArrayList<JSONObject> results = new ArrayList<>();

    public void users() throws JSONException {

        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            JSONObject oJsonInner = new JSONObject();
            oJsonInner.put("first_name", faker.name().firstName());
            oJsonInner.put("last_name", faker.name().lastName());
            oJsonInner.put("age", faker.number().randomNumber(2,true));
            oJsonInner.put("address", faker.address().fullAddress());
            users.add(oJsonInner);
        }
    }

    public void teams() throws JSONException {

        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            JSONObject oJsonInner = new JSONObject();
            oJsonInner.put("team_name", faker.team().name());
            teams.add(oJsonInner);
        }
    }

    public void countries() throws JSONException {

        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            JSONObject oJsonInner = new JSONObject();
            oJsonInner.put("country_name", faker.address().country());
            countries.add(oJsonInner);
        }
    }

    public void cities() throws JSONException {

        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            JSONObject oJsonInner = new JSONObject();
            oJsonInner.put("city_name", faker.address().city());
            cities.add(oJsonInner);
        }
    }

    public void sports() throws JSONException {

        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            JSONObject oJsonInner = new JSONObject();
            oJsonInner.put("sport_name", faker.team().sport());
            sports.add(oJsonInner);
        }
    }

    public void leagues() throws JSONException {

        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            JSONObject oJsonInner = new JSONObject();
            oJsonInner.put("league_name", faker.address().countryCode() + " " + faker.number().numberBetween(1,5) + " League");
            leagues.add(oJsonInner);
        }
    }

    @Scheduled(fixedRate = 5000)
    public void regenerateResults() throws JSONException {

        Faker faker = new Faker();
        results.clear();
        for (int i = 0; i < 10; i++) {
            JSONObject oJsonInner = new JSONObject();
            oJsonInner.put("firstPoints", faker.number().randomDigitNotZero());
            oJsonInner.put("secondPoints", faker.number().randomDigitNotZero());
            results.add(oJsonInner);
        }
    }


    FakerService() throws JSONException {
        this.users();
        this.teams();
        this.countries();
        this.cities();
        this.leagues();
        this.sports();
        this.regenerateResults();
    }

    public ArrayList<JSONObject> getTeams() {
        return teams;
    }

    public ArrayList<JSONObject> getSports() {
        return sports;
    }

    public ArrayList<JSONObject> getCountries() {
        return countries;
    }

    public ArrayList<JSONObject> getCities() {
        return cities;
    }

    public ArrayList<JSONObject> getLeagues() {
        return leagues;
    }

    public ArrayList<JSONObject> getResults()  {
        return results;
    }

    public ArrayList<JSONObject> getUsers() {
        return users;
    }
}
