package com.schedulerspringboot.service;

import com.schedulerspringboot.Entity.User;
import com.schedulerspringboot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;


@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repo;

    //Scheduler a job add object in DB (every 5sec)
    @Scheduled(fixedRate = 5000)
    public void addToDB() {
        User user = new User();

        user.setName("User"+new Random().nextInt(374483));

        repo.save(user);

        System.out.println("Add user in " + new Date().toString());
    }


    @Scheduled(cron = "0/15 * * * * *")
    public void fetchDB() {
        List<User> userList = repo.findAll();

        System.out.println("Fetch user in: " + new Date().toString());
        System.out.println("All user: " + userList.size());

        logger.info("List " + userList);
    }
}
