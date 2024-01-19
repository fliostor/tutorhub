package com.tutorhub.service.impl;

import com.tutorhub.model.Tutor;
import com.tutorhub.model.exception.ResourceNotFoundException;
import com.tutorhub.repository.TutorRepository;
import com.tutorhub.service.TutorService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TutorServiceImpl implements TutorService {
  private final TutorRepository tutorRepository;

  private  final PasswordEncoder passwordEncoder;

  @Override
  public Tutor getById(final ObjectId id) {
    return null;
  }

  @Override
  public Page<Tutor> getAll(final Pageable page) {
    return tutorRepository.findAll(page);
  }

  @Override
  public Tutor create(final Tutor entity) {
    return null;
  }

  @Override
  public Tutor update(final Tutor entity) {
    Tutor tutorOnDb =
        tutorRepository
            .findByUsername(entity.getUsername())
            .orElseThrow(
                () ->
                    new ResourceNotFoundException(
                        "Tutor with username[" + entity.getUsername() + "] not found."));

    entity.setId(tutorOnDb.getId());
    entity.setUsername(tutorOnDb.getUsername());
    entity.setPassword(passwordEncoder.encode(tutorOnDb.getPassword()));
    entity.setRole(tutorOnDb.getRole());

    return tutorRepository.save(entity);
  }

  @Override
  public boolean existsById(final ObjectId id) {
    return false;
  }

  @Override
  public void delete(final ObjectId id) {

  }
}
