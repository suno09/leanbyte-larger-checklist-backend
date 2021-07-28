package de.leanbyte.checklisttask.service;

import de.leanbyte.checklisttask.model.CheckList;
import de.leanbyte.checklisttask.repository.CheckListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * CheckList service for basic CRUD operations
 */
@Service
public class CheckListService {

    @Autowired
    private CheckListRepository checklistRepository;

    /**
     * To create an checklist
     *
     * @param checklist
     * @return checklist with new id
     */
    public CheckList save(CheckList checklist) {
        // Save the checklist
        return checklistRepository.save(checklist);
    }

    /**
     * To update an checklist
     *
     * @param checklist
     * @return the updated checklist
     */
    public CheckList update(CheckList checklist) {
        String checklistId = checklist.getId();
        if (checklistId == null || checklistId.isEmpty()) return null;

        // Update the checklist
        return checklistRepository.save(checklist);
    }

    /**
     * Find a single checklist by its id
     *
     * @param checklistId
     * @return checklist
     */
    public Optional<CheckList> getCheckList(String checklistId) {
        if (checklistId == null || checklistId.isEmpty()) return Optional.empty();
        return checklistRepository.findById(checklistId);
    }

    /**
     * Find all saved checklists so far
     *
     * @return
     */
    public Iterable<CheckList> findAll() {
        return checklistRepository.findAll();
    }

    /**
     * Delete a single checklist by its id
     *
     * @param checklistId
     */
    public void delete(String checklistId) {
        if (checklistId == null || checklistId.isEmpty()) return;
        checklistRepository.deleteById(checklistId);
    }
}