package org.vd.portal.support.data.repository;

/**
 * Created by bh on 16/05/2015.
 */

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vd.portal.support.data.model.Category;
import org.vd.portal.support.data.model.Suggestion;

/**
 * Created by bh on 16/05/2015.
 */
@Repository
public interface SuggestionRepository extends CrudRepository<Suggestion, Long> {

}

