package com.springinaction.spitter.alerts;

import com.springinaction.spitter.persistence.Spittle;

public interface AlertService {
	void sendSpittleAlert(Spittle spittle);
}
