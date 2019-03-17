package org.bitsly.bud.testtool;

import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {

	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void contextLoads() {
		stringRedisTemplate.opsForValue().setIfAbsent("testlock", "1", 10, TimeUnit.MINUTES);
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
