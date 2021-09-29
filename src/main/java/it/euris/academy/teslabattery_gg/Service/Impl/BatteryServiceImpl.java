package it.euris.academy.teslabattery_gg.Service.Impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.euris.academy.teslabattery_gg.Repository.BatteryRepository;
import it.euris.academy.teslabattery_gg.Service.BatteryService;
import it.euris.academy.teslabattery_gg.data.Dto.BatteryDto;
import it.euris.academy.teslabattery_gg.data.Dto.RobotDto;
import it.euris.academy.teslabattery_gg.data.Model.Battery;
import it.euris.academy.teslabattery_gg.data.Model.Robot;

@Service
public class BatteryServiceImpl implements BatteryService {

	@Autowired
	BatteryRepository batteryRepository;

	@Override
	public List<BatteryDto> getAll() {
		return batteryRepository.findAll().stream().map(Battery::toDto).collect(Collectors.toList());
	}

	@Override
	public BatteryDto get(Long id) {
		Optional<Battery> battery = batteryRepository.findById(id);
		return battery.isPresent()? battery.get().toDto(): null;
	}

	@Override
	public BatteryDto insert(BatteryDto batteryDto) {
		if(batteryDto.getBatteryId() != null)
			throw new RuntimeException();
		return batteryRepository.save(batteryDto.toModel()).toDto();
	}

	@Override
	public BatteryDto update(BatteryDto batteryDto) {
		if(batteryDto.getBatteryId() == null)
			throw new RuntimeException();
			return batteryRepository.save(batteryDto.toModel()).toDto();
	}

	@Override
	public Boolean delete(Long id) {
		batteryRepository.deleteById(id);
		return batteryRepository.findById(id).isEmpty();
	}

	@Override
	public List<BatteryDto> getBatteryByName(String name) {
		return batteryRepository.findBatteryByName(name).stream().map(Battery::toDto).collect(Collectors.toList());
	}

	@Override
	public List<BatteryDto> getBatteryByCreationDate(Instant creationDate) {
		return batteryRepository.findBatteryByCreationDate(creationDate).stream().map(Battery::toDto).collect(Collectors.toList());
	}

	@Override
	public List<BatteryDto> getBatteryByExpirationDate(Instant expirationDate) {
		return batteryRepository.findBatteryByExpirationDate(expirationDate).stream().map(Battery::toDto).collect(Collectors.toList());
	}

	@Override
	public Long getTotalBatteryRows() {
		return batteryRepository.getBatteryTotalRows();
	}

	@Override
	public Long getTotalBatteryRowsDeleted() {
		return batteryRepository.getBatteryTotalRowsDeleted();
	}

	@Override
	public Long getTotalBatteryRowsNotDeleted() {
		return batteryRepository.getBatteryTotalRowsNotDeleted();
	}
}
