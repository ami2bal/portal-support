package org.vd.portal.support.data.service;

import org.springframework.stereotype.Service;
import org.vd.portal.support.data.model.Suggestion;
import org.vd.portal.support.data.repository.SuggestionRepository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bh on 17/05/2015.
 */
@Service
public class SuggestionService {

    @Resource
    private SuggestionRepository suggestionRepository;

    /**
     * Return the suggestions matching with the given category id
     *
     * @param idCategory
     * @return
     */
    public List<Suggestion> findByCategoryId(Long idCategory) {
        Iterable<Suggestion> suggestionIterable = suggestionRepository.findAll();
        List<Suggestion> suggestionList = new ArrayList<>();
        for (Suggestion suggestion : suggestionIterable) {
            if (idCategory == suggestion.getCategory().getId())
                suggestionList.add(suggestion);
        }
        return suggestionList;
    }


}
