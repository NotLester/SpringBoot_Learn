package org.lester.springbootlearn.homework1.services;

import org.lester.springbootlearn.homework1.entities.AdmissionRecord;
import org.lester.springbootlearn.homework1.entities.Student;
import org.lester.springbootlearn.homework1.repositories.AdmissionRecordRepository;
import org.lester.springbootlearn.homework1.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdmissionRecordService {
    private final AdmissionRecordRepository admissionRecordRepository;
    private final StudentRepository studentRepository;

    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository, StudentRepository studentRepository) {
        this.admissionRecordRepository = admissionRecordRepository;
        this.studentRepository = studentRepository;
    }

    public List<AdmissionRecord> getAllAdmissionRecords() {
        return admissionRecordRepository.findAll();
    }

    public AdmissionRecord admitNewStudent(Long studentId, Integer fees) {
        Optional<Student> student = studentRepository.findById(studentId);

        return student.map(value ->
                admissionRecordRepository.save(
                        new AdmissionRecord(fees, value)
                )
        ).orElse(null);
    }
}
