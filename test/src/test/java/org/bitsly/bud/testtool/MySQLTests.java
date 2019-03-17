package org.bitsly.bud.testtool;

import lombok.extern.slf4j.Slf4j;
import org.fluentd.logger.FluentLogger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MySQLTests {
	private static FluentLogger LOG = FluentLogger.getLogger("app", "192.168.192.111", 24224);


	@Test
	public void t() throws InterruptedException  {
		log.info("1163619f3bfe1038c538d9f9f4e4039d".substring(0, 8));
		Thread.currentThread().join();
	}

}
