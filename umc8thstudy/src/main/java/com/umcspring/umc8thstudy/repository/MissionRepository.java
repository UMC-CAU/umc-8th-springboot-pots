package com.umcspring.umc8thstudy.repository;

import com.umcspring.umc8thstudy.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
