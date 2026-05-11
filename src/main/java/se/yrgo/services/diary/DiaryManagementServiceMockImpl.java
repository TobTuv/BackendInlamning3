package se.yrgo.services.diary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import se.yrgo.domain.Action;

@Service
@Transactional
public class DiaryManagementServiceMockImpl implements DiaryManagementService {

	private Set<Action> allActions = new HashSet<>();

	@Override
	public void recordAction(Action action) {
		allActions.add(action);
	}

	@Override
	public List<Action> getAllIncompleteActions(String requiredUser) {
		return new ArrayList<>(allActions);
	}
}
