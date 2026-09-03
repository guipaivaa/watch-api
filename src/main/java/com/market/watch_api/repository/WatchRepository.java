package com.market.watch_api.repository;

import com.market.watch_api.entity.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WatchRepository extends JpaRepository<Watch, UUID>, JpaSpecificationExecutor<Watch> {
}
