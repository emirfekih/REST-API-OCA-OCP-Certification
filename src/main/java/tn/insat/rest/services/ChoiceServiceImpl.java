package tn.insat.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.insat.rest.entities.Choice;
import tn.insat.rest.repositories.ChoiceRepository;

import java.util.List;

/**
 * Created by zied on 19/02/2018.
 */
@Service
public class ChoiceServiceImpl implements ChoiceService {

    private ChoiceRepository choiceRepository;

    @Autowired
    public void setChoiceRepository(ChoiceRepository choiceRepository) {
        this.choiceRepository = choiceRepository;
    }

    @Override
    public List<Choice> getChoices() {
        return choiceRepository.findAll();
    }
}
