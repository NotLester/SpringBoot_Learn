package org.lester.springbootlearn.homework1.services;

import org.lester.springbootlearn.homework1.entities.Professor;
import org.lester.springbootlearn.homework1.entities.Subject;
import org.lester.springbootlearn.homework1.repositories.ProfessorRepository;
import org.lester.springbootlearn.homework1.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final ProfessorRepository professorRepository;

    public SubjectService(SubjectRepository subjectRepository, ProfessorRepository professorRepository) {
        this.subjectRepository = subjectRepository;
        this.professorRepository = professorRepository;
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }
//
//    public Subject assignSubjectToProfessor(Long subjectId, Long professorId) {
//        Optional<Subject> subject = subjectRepository.findById(subjectId);
//        Optional<Professor> professor = professorRepository.findById(professorId);
//
//        return subject.flatMap(sub -> professor.map(prof -> {
//            sub.setProfessor(prof);
//            prof.getSubjects().add(sub);
//            return subjectRepository.save(sub);
//        })).orElse(null);
//    }
}
