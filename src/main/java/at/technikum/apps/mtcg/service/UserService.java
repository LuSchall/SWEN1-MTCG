package at.technikum.apps.mtcg.service;

import at.technikum.apps.mtcg.entity.User;
import at.technikum.apps.mtcg.entityJson.UserJson;
import at.technikum.apps.mtcg.entityJson.UserProfileJson;
import at.technikum.apps.mtcg.entityJson.UserStatsJson;
import at.technikum.apps.mtcg.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user) {
        userRepository.saveInDB(user);
    }

    public Optional<User> getUserByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    public UserJson getUserJsonFromBody(String body) {
        UserJson userJson;
        try {
            userJson = objectMapper.readValue(body, UserJson.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return userJson;
    }

    public String getJsonUserProfileAsString(User user) {
        String profile;
        //System.out.println("1  USERNAME: "+user.getUsername());
        UserProfileJson userProfile = getUserProfileJson(user);
        //System.out.println("2  PROFILE-JSON: "+userProfile.getName()+userProfile.getBio()+userProfile.getImage());
        try {
            profile = objectMapper.writeValueAsString(userProfile);
            //System.out.println("3  PROFILE-STRING: "+test);
            return profile;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUserProfile(String username, String body) {
        UserProfileJson userProfile;
        //System.out.println(body);
        try {
            userProfile = objectMapper.readValue(body, UserProfileJson.class);
            //System.out.println(userProfile.getName());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        userRepository.updateUserProfile(username, userProfile.getName(), userProfile.getBio(), userProfile.getImage());
    }

    public String getScoreboardAsJsonString() {
        List<User> orderedUsers = userRepository.getSortedUsersByElo();
        List<UserStatsJson> orderedStats = new ArrayList<>();
        for (User user : orderedUsers) {
            orderedStats.add(getUserStatsJson(user));
        }
        String orderedStatsString;
        try {
            orderedStatsString = objectMapper.writeValueAsString(orderedStats);
            return orderedStatsString;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getStatsAsJsonString(String username) {
        User user = getUserByUsername(username).get();
        String stats;
        UserStatsJson userStatsJson = getUserStatsJson(user);
        try {
            stats = objectMapper.writeValueAsString(userStatsJson);
            return stats;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private UserProfileJson getUserProfileJson(User user) {
        UserProfileJson profileJson = new UserProfileJson();
        profileJson.setName(user.getProfileName());
        profileJson.setBio(user.getBio());
        profileJson.setImage(user.getImage());
        return profileJson;
    }

    private UserStatsJson getUserStatsJson(User user) {
        UserStatsJson statsJson = new UserStatsJson();
        statsJson.setName(user.getProfileName());
        statsJson.setElo(user.getElo());
        statsJson.setWins(user.getWins());
        statsJson.setLosses(user.getLosses());
        return statsJson;
    }


}
