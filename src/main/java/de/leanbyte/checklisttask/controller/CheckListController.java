package de.leanbyte.checklisttask.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.leanbyte.checklisttask.model.CheckList;
import de.leanbyte.checklisttask.service.CheckListService;
import de.leanbyte.checklisttask.vo.CheckListDetail;
import de.leanbyte.checklisttask.vo.CheckListLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/checklists")
@Slf4j
public class CheckListController {
    @Autowired
    private CheckListService checkListService;

    /**
     * Get the list of all checklist
     *
     * @return list of checklist
     */
    @GetMapping
    public Iterable<CheckList> getCheckLists() {
        log.debug("Get the list of checklist");
        return checkListService.findAll();
    }

    /**
     * Find a checklist by its id
     *
     * @param id
     * @return CheckList
     */
    @GetMapping("/{id}")
    public Optional<CheckList> getCheckList(@PathVariable String id) {
        log.debug("Load the checklist of id: {}", id);
        return checkListService.getCheckList(id);
    }

    /**
     * Find a checklist detail by its id
     *
     * @param id
     * @return CheckList
     */
    @GetMapping("/detail/{id}")
    public CheckListDetail getCheckListDetail(@PathVariable String id) {
        log.debug("Load the checklist detail of id: {}", id);
        Optional<CheckList> checkListOptional = checkListService.getCheckList(id);
        if (checkListOptional.isEmpty()) {
            return new CheckListDetail();
        }

        CheckList checkList = checkListOptional.get();
        CheckListDetail checkListDetail = new CheckListDetail();
        checkListDetail.setId(checkList.getId());
        checkListDetail.setTitle(checkList.getTitle());
        checkListDetail.setChecklists(
                Arrays
                        .stream(checkList.getChecklists())
                        .map(ids -> new CheckListLevel(ids,
                                Arrays
                                        .stream(ids)
                                        .map(idl -> checkListService.getCheckList(idl).orElse(new CheckList()).getTitle())
                                        .collect(Collectors.joining(" / "))))
                        .toArray(CheckListLevel[]::new));

        return checkListDetail;
    }

    /**
     * Create or update a checklist
     *
     * @param checkList : checklist object
     * @return checklist inserted or updated
     */
    @PostMapping
    public CheckList createOrUpdateCheckList(@RequestBody CheckList checkList) {
        log.debug("Create or update a checklist: {}", checkList);
        return checkListService.save(checkList);
    }

    /**
     * Delete checklists
     *
     * @param ids list of id of the checklists want to delete
     * @return boolean of success or failure
     * @throws JsonProcessingException
     */
    @PostMapping("/delete")
    public boolean deleteCheckList(@RequestBody List<String> ids) throws JsonProcessingException {
        log.debug("delete checklists");
        ids.forEach(id -> checkListService.delete(id));

        return true;
    }
}
