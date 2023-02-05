package com.example.Eventeam.service;

import com.example.Eventeam.entity.MatchToTaskToUser;
import com.example.Eventeam.entity.Task;
import com.example.Eventeam.repository.SetUpMatchRepository;
import com.example.Eventeam.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetUpMatchService {
    private final SetUpMatchRepository setUpMatchRepository;

    @Autowired
    public SetUpMatchService(SetUpMatchRepository setUpMatchRepository) {
        this.setUpMatchRepository = setUpMatchRepository;
    }

    public MatchToTaskToUser saveSetUpToDB(MatchToTaskToUser connect) {
        return setUpMatchRepository.save(connect);
    }

    public List<MatchToTaskToUser> getSetUpByMatchId(Long id){
        return setUpMatchRepository.getTasksByMatchId(id);
    }

    public List<Task> getTaskAssignedToMatch(Long id) {
        List<MatchToTaskToUser> connect = setUpMatchRepository.getTasksByMatchId(id);
        List<Task> tasks = connect.stream().map(MatchToTaskToUser::getTask).collect(Collectors.toList());
//        List<Task> allTasks = taskRepository.findAll();

//        allTasks.removeAll(tasks);

        return tasks;
    }
}
