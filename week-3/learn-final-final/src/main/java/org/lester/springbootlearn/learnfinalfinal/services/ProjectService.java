package org.lester.springbootlearn.learnfinalfinal.services;

import org.lester.springbootlearn.learnfinalfinal.entities.Project;
import org.lester.springbootlearn.learnfinalfinal.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createNewProject(Project project) {
        return projectRepository.save(project);
    }

    public Project findProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }
}
