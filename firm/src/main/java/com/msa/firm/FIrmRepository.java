package com.msa.firm;

import com.msa.firm.domain.Firm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FIrmRepository extends JpaRepository<Firm, Long> {

}
