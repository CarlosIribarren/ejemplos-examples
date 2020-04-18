package oiasso.systems.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BillingCollectorCron {

    private static final Logger LOG = LoggerFactory.getLogger(BillingCollectorCron.class);

	@Scheduled(cron = "${cron.expression}")
	public void billingCollectorStart() {

		LOG.info("ejecutando");

	}

}