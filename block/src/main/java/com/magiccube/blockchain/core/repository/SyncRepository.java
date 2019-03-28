package com.magiccube.blockchain.core.repository;

import com.magiccube.blockchain.core.model.SyncEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SyncRepository extends JpaRepository<SyncEntity, Long> {
    SyncEntity findTopByOrderByIdDesc();
}
