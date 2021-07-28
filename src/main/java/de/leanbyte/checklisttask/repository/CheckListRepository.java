package de.leanbyte.checklisttask.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import de.leanbyte.checklisttask.model.CheckList;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckListRepository extends ArangoRepository<CheckList, String> { }
