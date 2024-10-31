package com.microsoft.microject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microsoft.microject.domain.Rega;

public interface RegaRepository extends JpaRepository<Rega, Long> {
}
