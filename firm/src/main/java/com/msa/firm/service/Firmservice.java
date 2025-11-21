package com.msa.firm.service;

import com.msa.firm.FIrmRepository;
import com.msa.firm.domain.Firm;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class Firmservice {
    private final FIrmRepository firmRepository;

    @Transactional
    public List<Firm> findAll() {
        return firmRepository.findAll();
    }

    @Transactional
    public Firm findById (Long firmId) {
        return firmRepository.findById(firmId).orElse(null);
    }

    @Transactional
    public Firm create(Firm firm) {
        return firmRepository.save(firm);
    }

    @Transactional
    public Firm update(Long firmId, Firm firm) {
        Firm existingFirm = firmRepository.findById(firmId).orElse(null);
        existingFirm.setFirmId(firm.getFirmId());

        return firmRepository.save(existingFirm);
    }

    @Transactional
    public void deleteById (Long firmId) {
        firmRepository.deleteById(firmId);
    }

}
