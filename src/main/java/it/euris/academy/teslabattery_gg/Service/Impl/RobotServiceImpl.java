package it.euris.academy.teslabattery_gg.Service.Impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.euris.academy.teslabattery_gg.Repository.RobotRepository;
import it.euris.academy.teslabattery_gg.Service.RobotService;
import it.euris.academy.teslabattery_gg.data.Dto.RobotDto;
import it.euris.academy.teslabattery_gg.data.Model.Robot;

@Service
public class RobotServiceImpl implements RobotService {

	@Autowired
	RobotRepository robotRepository;
	
	@Override
	public List<RobotDto> getAll() {
		return robotRepository.findAll().stream().map(Robot::toDto).collect(Collectors.toList());
	}

	@Override
	public RobotDto get(Long id) {
		Optional<Robot> robot = robotRepository.findById(id);
		return robot.isPresent()? robot.get().toDto(): null;
	}

	@Override
	public RobotDto insert(RobotDto robotDto) {
		if(robotDto.getRobotId() != null)
			throw new RuntimeException();
		return robotRepository.save(robotDto.toModel()).toDto();
	}

	@Override
	public RobotDto update(RobotDto robotDto) {
		if(robotDto.getRobotId() == null)
			throw new RuntimeException();
		return robotRepository.save(robotDto.toModel()).toDto();
	}

	@Override
	public Boolean delete(Long id) {
		robotRepository.deleteById(id);
		return robotRepository.findById(id).isEmpty();
	}

	@Override
	public List<RobotDto> getRobotByRobotCode(String robotCode) {
		return robotRepository.findRobotByRobotCode(robotCode).stream().map(Robot::toDto).collect(Collectors.toList());
	}

	@Override
	public List<RobotDto> getRobotByFunction(String function) {
		return robotRepository.findRobotByFunction(function).stream().map(Robot::toDto).collect(Collectors.toList());
	}

	@Override
	public List<RobotDto> getRobotByCreationDate(Instant creationDate) {
		return robotRepository.findRobotByCreationDate(creationDate).stream().map(Robot::toDto).collect(Collectors.toList());
	}

	@Override
	public Long getTotalRobotRows() {
		return robotRepository.getRobotTotalRows();
	}

	@Override
	public Long getTotalRobotRowsDeleted() {
		return robotRepository.getRobotTotalRowsDeleted();
	}

	@Override
	public Long getTotalRobotRowsNotDeleted() {
		return robotRepository.getRobotTotalRowsNotDeleted();
	}

}
