package com.fpr.persistence;

import com.fpr.domain.Saving;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingRepository extends JpaRepository<Saving, Long> {

}
